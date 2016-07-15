import Utils.AppUtils;
import Views.MainFrame;

public class App {


    public static void main(String[] args) {

        AppUtils.fetchDataFromDB();


//
//        for(Terapie x : terapieService.getTerapiesForTerapeut(terapeutService.getAllTerapeuts().get(0)))
//            System.out.println(x.getNume() + " "  + x.getId());


//        for(Terapie x : terapieService.getAllTerapies())
//            System.out.println(x.getNume() + " " + x.getId());

        new MainFrame().setVisible(true);

    }
}
