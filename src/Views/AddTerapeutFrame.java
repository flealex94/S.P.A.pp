package Views;

import Database.DatabaseManager;
import Database.Services.TerapeutService;
import Pojos.Terapeut;
import Pojos.Terapie;
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

        DefaultListModel<Terapie> terapieDefaultListModel = new DefaultListModel<>();
        list1.setModel(terapieDefaultListModel);

        comboBox1.setModel(new DefaultComboBoxModel(AppUtils.getLocalTerapies().toArray()));

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

        adaugăTerapieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String terapyName = ((Terapie)comboBox1.getSelectedItem()).getNume();
                terapieDefaultListModel.addElement(new Terapie(terapyName));
            }
        });

        salveazăButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TerapeutService ts = TerapeutService.getInstance(DatabaseManager.getInstance().getConn());
                Terapeut terapeut = new Terapeut(textField1.getText(), textField2.getText(), comboBox2.getSelectedItem().toString());

                ts.saveTerapeut(terapeut);
                System.out.println("Terapeut adaugat in BD!");


                textField1.setText("");
                textField2.setText("");
                DefaultListModel listModel = (DefaultListModel) list1.getModel();
                listModel.removeAllElements();
            }
        });
    }

}
