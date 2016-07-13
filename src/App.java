import Database.DatabaseManager;
import Views.MainFrame;

public class App {


    public static void main(String[] args){

        System.out.println("teddy e sexy");
        System.out.println("Connecting to database .... please wait!");

        // App's Managers
        DatabaseManager dbManager = DatabaseManager.getInstance();

        new MainFrame().setVisible(true);

    }
}
