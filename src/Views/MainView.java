package Views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by teodor on 29.06.2016.
 */
public class MainView extends JFrame{
    private JButton configurareButton;
    private JButton vizualizareButton;
    private JButton adaugareButton;
    private JButton iesireButton;
    private JLabel appNameLabel;
    private JPanel rootPanel;

    public MainView() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get 2/3 of the height, and 2/3 of the width
        setContentPane(rootPanel);
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;

        // set the jframe height and width
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(height + " " + width);
    }
}
