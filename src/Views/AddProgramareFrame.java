package Views;

import GA.AG;
import Utils.AppUtils;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;



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
                AG.Optimizare();

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
                Calendar c = Calendar.getInstance();
                c.setTime(selectedDate);
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // SUNDAY - 1 ... SAT - 7

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
