package Utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by teodor on 29.06.2016.
 */
public class AppUtils {
    public static void setFrameDimension(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get 2/3 of the height, and 2/3 of the width
        int height = (int)(screenSize.height * 2.5 / 3);
        int width = (int)(screenSize.width * 2.5 / 3);

        // set the jframe height and width
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public static void centerFrame(JFrame frame) {
        //positioning frame in the center of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width/2 - frame.getSize().width/2, screenSize.height/2 - frame.getSize().height/2);
    }

}
