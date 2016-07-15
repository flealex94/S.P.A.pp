package Views;

import Database.DatabaseManager;
import Utils.AppUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFrame extends JFrame {
    private JButton configurareButton;
    private JButton vizualizareButton;
    private JButton adaugareButton;
    private JButton iesireButton;
    private JLabel appNameLabel;
    private JPanel rootPanel;

    public MainFrame() {
        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        adaugareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent);
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AddProgramareFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        configurareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new ConfigurationFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        vizualizareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new VizualizationFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        // exit button
        iesireButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    DatabaseManager.getInstance().getConn().close();
                    System.out.println("Conexiune la baza de date inchisa!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                dispose(); //Destroy the JFrame object
                System.exit(0);
            }
        });
    }
}
