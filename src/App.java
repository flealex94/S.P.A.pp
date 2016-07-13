import Database.DatabaseManager;
import Database.Services.ClientService;
import Database.Services.TerapeutService;
import Database.Services.TerapieService;
import Pojos.Client;
import Pojos.Terapie;
import Views.MainFrame;

public class App {


    public static void main(String[] args) {

        System.out.println("teddy e sexy");
        System.out.println("Connecting to database .... please wait!");

        // App's Managers
        DatabaseManager dbManager = DatabaseManager.getInstance();

        ClientService clientService = new ClientService(dbManager.getConn());
        TerapieService terapieService = new TerapieService(dbManager.getConn());
        TerapeutService terapeutService = new TerapeutService(dbManager.getConn());

        System.out.println(clientService.getAllClients());
        System.out.println(terapieService.getAllTerapies());
        System.out.println(terapeutService.getAllTerapeuts());
        System.out.println("\n\n\n\n\n");



        for(Terapie x : terapieService.getTerapiesForTerapeut(terapeutService.getAllTerapeuts().get(0)))
            System.out.println(x.getNume() + " "  + x.getId());


//        for(Terapie x : terapieService.getAllTerapies())
//            System.out.println(x.getNume() + " " + x.getId());

        new MainFrame().setVisible(true);

    }
}