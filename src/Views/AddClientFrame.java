package Views;

import Utils.AppUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by teodor on 30.06.2016.
 */
public class AddClientFrame extends JFrame{
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton resetButton;
    private JButton salveazăButton;
    private JButton inapoiButton;

    public AddClientFrame() {

        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        inapoiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AppointmentFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });
    }
}
