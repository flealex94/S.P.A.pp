package Views;

import GA.Programare;
import Pojos.Terapie;
import Utils.AppUtils;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class AddProgramareFrame extends JFrame {
    private AppUtils appUtils;
    private JPanel rootPanel;
    private JLabel titleLabel;
    private JDatePickerImpl JDatePickerImpl1;
    private JLabel clientLabel;
    private JList dateDisponibileList;
    private JButton adaugaClientButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JSpinner orăÎnceputSpinner;
    private JButton ștergeIntervalButton;
    private JButton inapoiButton;
    private JButton salveazăButton;
    private JSpinner spinner1;
    private JButton adaugăIntervalButton;

    public AddProgramareFrame() {
        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        DefaultListModel<Interval> intervalsModel = new DefaultListModel<Interval>();
        dateDisponibileList.setModel(intervalsModel);

        comboBox1.setModel(new DefaultComboBoxModel(AppUtils.getLocalTerapies().toArray()));

        adaugaClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AddClientFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        inapoiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new MainFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        adaugăIntervalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date selectedDate = (Date) JDatePickerImpl1.getModel().getValue();
                int oraInceput = (int)orăÎnceputSpinner.getValue();
                int oraFinal = (int)spinner1.getValue();

                if (oraInceput >= 9 && oraFinal <= 19 && selectedDate != null) {
                    Calendar c = Calendar.getInstance();
                    c.setTime(selectedDate);

                    intervalsModel.addElement(
                            new Interval(
                                    oraInceput,
                                    oraFinal,
                                    selectedDate,
                                    AppUtils.daysOfWeek[c.get(Calendar.DAY_OF_WEEK)-1]
                            )
                    );
                }
            }
        });

        ștergeIntervalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("interval sters!");
            }
        });

        salveazăButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String clientName = textField1.getText();
                String terapyName = ((Terapie)comboBox1.getSelectedItem()).getNume();
                HashMap<String, Vector<Integer>> intervaleDisponibilitate = new HashMap<String, Vector<Integer>>();
                for(int i = 0; i < 7;i ++)
                    intervaleDisponibilitate.put(AppUtils.daysOfWeek[i], new Vector<Integer>());

                Calendar c = Calendar.getInstance();

                for (int index = 0; index < intervalsModel.getSize(); index ++) {
                    Interval interval = intervalsModel.getElementAt(index);
                    c.setTime(interval.data);
                    String day = AppUtils.daysOfWeek[c.get(Calendar.DAY_OF_WEEK)-1];
                    Vector<Integer> intervalsVector = intervaleDisponibilitate.get(day);
                    for (int i = interval.oraInceput; i < interval.oraFinal; i++ )
                        intervalsVector.add(i);
                }

                //System.out.println(intervaleDisponibilitate);

                Programare nouaProgramare = new Programare(clientName, terapyName, intervaleDisponibilitate);
                AppUtils.addProgramare(nouaProgramare);
                System.out.println("Programare adaugata in lista!");

                //clean up phase
                textField1.setText("");
                orăÎnceputSpinner.setValue(new Integer(0));
                spinner1.setValue(new Integer(0));
                DefaultListModel listModel = (DefaultListModel) dateDisponibileList.getModel();
                listModel.removeAllElements();
            }
        });
    }

    private void createUIComponents() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
        JDatePickerImpl1 = new JDatePickerImpl(datePanel, new JFormattedTextField.AbstractFormatter() {
            private String datePattern = "yyyy-MM-dd";
            private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

            @Override
            public Object stringToValue(String text) throws ParseException {
                return dateFormatter.parseObject(text);
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                if (value != null) {
                    Calendar cal = (Calendar) value;
                    return dateFormatter.format(cal.getTime());
                }

                return "";
            }
        });

    }

}

class Interval {
    int oraInceput, oraFinal;
    Date data;
    String day;

    public Interval() {
        data = new Date();
        oraFinal = oraInceput = 0;
    }

    public Interval(int oraInceput, int oraFinal, Date data, String day) {
        this.oraInceput = oraInceput;
        this.oraFinal = oraFinal;
        this.data = data;
        this.day = day;
    }

    public String toString() {
        return day + " de la " + oraInceput + " pana la " + oraFinal;
    }

}

