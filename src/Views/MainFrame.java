package Views;

import Utils.AppUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by teodor on 29.06.2016.
 */
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
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent);
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AppointmentFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

    }

    public void onAdaugareButton() {

    }

}
