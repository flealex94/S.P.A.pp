package Views;

import Utils.AppUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddTerapeutFrame extends JFrame {

    private JTextField textField1;
    private JTextField textField2;
    private JButton adaugăTerapieButton;
    private JComboBox comboBox1;
    private JList list1;
    private JButton salveazăButton;
    private JButton resetButton;
    private JButton inapoiButton;
    private JPanel rootPanel;
    private JComboBox comboBox2;

    public AddTerapeutFrame() {
        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        inapoiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new ConfigurationFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField1.setText("");
                textField2.setText("");
                DefaultListModel listModel = (DefaultListModel) list1.getModel();
                listModel.removeAllElements();
            }
        });

        salveazăButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("terapeut adaugat!");


                textField1.setText("");
                textField2.setText("");
                DefaultListModel listModel = (DefaultListModel) list1.getModel();
                listModel.removeAllElements();
            }
        });
    }

}
