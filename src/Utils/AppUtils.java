package Utils;

import Database.DatabaseManager;
import Database.Services.ClientService;
import Database.Services.TerapeutService;
import Database.Services.TerapieService;
import Pojos.Client;
import Pojos.Terapeut;
import Pojos.Terapie;
import com.j256.ormlite.support.ConnectionSource;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    ClientService clientService;
    TerapieService terapieService;
    TerapeutService terapeutService;

    static List<Client> clients = null;
    static List<Terapie> terapies = null;
    static List<Terapeut> terapeuti = null;
    static List<Programare> programari = null;

    static ArrayList<Programare> programariNecalculate = new ArrayList<Programare>();

    public static String[] daysOfWeek = {"Duminica", "Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata"};

    public static void setFrameDimension(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get 2/3 of the height, and 2.3/3 of the width
        int height = (int)(screenSize.height * 2 / 3);
        int width = (int)(screenSize.width * 2.3 / 3);

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

    public static void fetchDataFromDB() {

        // App's Managers
        DatabaseManager dbManager = DatabaseManager.getInstance();
        ConnectionSource conn = dbManager.getConn();

        ClientService clientService = ClientService.getInstance(conn);
        TerapieService terapieService =  TerapieService.getInstance(conn);
        TerapeutService terapeutService =  TerapeutService.getInstance(conn);
        //ProgramareService programareService = ProgramareService.getInstance(conn);

        clients = clientService.getAllClients();
        terapies = terapieService.getAllTerapies();
        terapeuti = terapeutService.getAllTerapeuts();
        //programari = programareService.getAllProgramari();

        System.out.println("\nDate preluate cu succes din baza de date!\n");
    }

    public static List<Client> getLocalClients() {
        if (clients == null)
            fetchDataFromDB();
        return clients;
    }

    public static List<Terapie> getLocalTerapies() {
        if (terapies == null)
            fetchDataFromDB();
        return terapies;
    }

    public static List<Terapeut> getLocalTerapeuts() {
        if (terapeuti == null)
            fetchDataFromDB();
        return terapeuti;
    }

    public static List<Pojos.Programare> getLocalProgramari() {
        if (programari == null)
            fetchDataFromDB();
        return programari;
    }


    public static void addProgramare(Programare programare) {
        programariNecalculate.add(programare);
    }

    public static ArrayList<Programare> getProgramariNecalculate() {
        return programariNecalculate;
    }

    public static String getTerapieByClientName(String numeClient) {
        for (Programare programare : programariNecalculate){
            if (programare.getName().equalsIgnoreCase(numeClient))
                return programare.getTerapie();
        }
        return programariNecalculate.get(0).getTerapie();
    }

    public static Terapeut getTerapeutForTerapie(String numeTerapie) {

        DatabaseManager dbManager = DatabaseManager.getInstance();
        ConnectionSource conn = dbManager.getConn();

        TerapieService terapieService =  TerapieService.getInstance(conn);
        TerapeutService terapeutService =  TerapeutService.getInstance(conn);
        List<Terapeut> terapeutList = terapeutService.getAllTerapeuts();

        for(Terapeut terapeut : terapeutList){
            for(Terapie terapie : terapieService.getTerapiesForTerapeut(terapeut)){
                if (terapie.getNume().equalsIgnoreCase(numeTerapie))
                    return terapeut;
            }
        }
        return terapeutList.get(0);
    }

    public static Client getClientByName(String numeClient) {
        List<Client> clientList = ClientService.getInstance(DatabaseManager.getInstance().getConn()).getAllClients();

        for (Client client: clientList){
            if (client.getNume().equalsIgnoreCase(numeClient))
                return client;
        }
        String[] parts = numeClient.split(" ");
        return new Client(parts[0],parts[1],"0742736751","Andy@boom.com","M");
    }

}
