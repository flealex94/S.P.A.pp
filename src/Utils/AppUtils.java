package Utils;

import Database.DatabaseManager;
import Database.Services.ClientService;
import Database.Services.TerapeutService;
import Database.Services.TerapieService;
import GA.Programare;
import Pojos.Client;
import Pojos.Terapeut;
import Pojos.Terapie;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.*;

/**
 * Created by teodor on 29.06.2016.
 */
public class AppUtils {

    ClientService clientService;
    TerapieService terapieService;
    TerapeutService terapeutService;

    static List<Client> clients = null;
    static List<Terapie> terapies = null;
    static List<Terapeut> terapeuti = null;

    static ArrayList<Programare> programariNecalculate = new ArrayList<Programare>();

    public static String[] daysOfWeek = {"Duminica", "Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata"};

    public static void setFrameDimension(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get 2/3 of the height, and 2/3 of the width
        int height = (int)(screenSize.height * 2.5 / 3);
        int width = (int)(screenSize.width * 1.5 / 3);

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

        ClientService clientService = new ClientService(dbManager.getConn());
        TerapieService terapieService = new TerapieService(dbManager.getConn());
        TerapeutService terapeutService = new TerapeutService(dbManager.getConn());

        clients = clientService.getAllClients();
        terapies = terapieService.getAllTerapies();
        terapeuti = terapeutService.getAllTerapeuts();

        System.out.println(clients);
        System.out.println(terapies);
        System.out.println(terapeuti);
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


    public static void addProgramare(Programare programare) {
        programariNecalculate.add(programare);
    }

    public static ArrayList<Programare> getProgramariNecalculate() {
        return programariNecalculate;
    }
}
