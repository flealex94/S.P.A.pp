package Views;

import Utils.AppUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddTerapieFrame extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JList list1;
    private JButton adaugăButton;
    private JButton salveazăButton;
    private JButton resetButton;
    private JButton inapoiButton;
    private JPanel rootPanel;

    public AddTerapieFrame() {
        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new ConfigurationFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

    }
}
