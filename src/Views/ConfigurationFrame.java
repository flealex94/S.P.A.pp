package Views;

import Utils.AppUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigurationFrame extends JFrame {
    private JLabel titleLabel;
    private JList list1;
    private JList list2;
    private JPanel rootPanel;
    private JButton addTerapeutButton;
    private JButton addTerapieButton;
    private JButton inapoiButton;

    public ConfigurationFrame() {
        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        list1.setListData(AppUtils.getLocalTerapeuts().toArray());
        list2.setListData(AppUtils.getLocalTerapies().toArray());

        inapoiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new MainFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        addTerapeutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AddTerapeutFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        addTerapieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new AddTerapieFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });
    }

}
