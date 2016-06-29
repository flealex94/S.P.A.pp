package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by teodor on 29.06.2016.
 */
public class MainFrame extends JFrame{
    private JButton configurareButton;
    private JButton vizualizareButton;
    private JButton adaugareButton;
    private JButton iesireButton;
    private JLabel appNameLabel;
    private JPanel rootPanel;

    public MainFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get 2/3 of the height, and 2/3 of the width
        setContentPane(rootPanel);
        int height = (int)(screenSize.height * 2.5 / 3);
        int width = (int)(screenSize.width * 2.5 / 3);

        // set the jframe height and width
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocation(screenSize.width/2 - getSize().width/2, screenSize.height/2 - getSize().height/2);

    }
}
