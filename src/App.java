import Database.DatabaseManager;
import Utils.AppUtils;
import Views.MainFrame;

import javax.swing.*;
import java.awt.*;

public class App {


    public static void main(String[] args){

        System.out.println("teddy e sexy");
        System.out.println("Connecting to database .... please wait!");

        // App's Managers
        DatabaseManager dbManager = DatabaseManager.getInstance();

        new MainFrame().setVisible(true);

    }
}
