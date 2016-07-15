import Utils.AppUtils;
import Views.MainFrame;

public class App {


    public static void main(String[] args) {

        AppUtils.fetchDataFromDB();

        new MainFrame().setVisible(true);

    }
}
