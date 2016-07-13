package Views;

import Utils.AppUtils;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;


/**
 * Created by teodor on 29.06.2016.
 */
public class AppointmentFrame extends JFrame {
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
    private JButton ștergeDataButton;
    private JButton inapoiButton;
    private JButton salveazăButton;
    private JSpinner spinner1;

    public AppointmentFrame() {
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
                setVisible(false); //you can't see me!
                JFrame nextFrame = new MainFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
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
