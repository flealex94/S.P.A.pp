package Views;

import Database.DatabaseManager;
import Database.Services.ClientService;
import Pojos.Client;
import Utils.AppUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddClientFrame extends JFrame{
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton resetButton;
    private JButton salveazăButton;
    private JButton inapoiButton;
    private JComboBox comboBox1;

    public AddClientFrame() {

        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        inapoiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AddProgramareFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        salveazăButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientService cs =  ClientService.getInstance(DatabaseManager.getInstance().getConn());
                Client client = new Client(textField1.getText(),textField2.getText(),textField4.getText(),textField3.getText(),comboBox1.getSelectedItem().toString());

                cs.saveClient(client);
                System.out.println("Client adaugat in BD!");

                setVisible(false); //you can't see me!
                JFrame nextFrame = new AddProgramareFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
            }
        });
    }

}
