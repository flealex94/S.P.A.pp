package Database.Services;

import Database.DaoImplementations.ProgramareDaoImpl;
import Pojos.Programare;
import Utils.AppUtils;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;


public class ProgramareService {
    private static ProgramareService instance = null;
    ConnectionSource conn = null;
    ProgramareDaoImpl programareStore;

    public static ProgramareService getInstance(ConnectionSource conn){
        if (instance == null){
            instance = new ProgramareService(conn);
        }
        return instance;
    }

    private ProgramareService(ConnectionSource conn) {

        try {
            programareStore = new ProgramareDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Programare> getAllProgramari() {

        List<Programare> ret = null;
        try {
            ret = programareStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public int saveProgramare(Programare newProgramare) {
        int id = -1;
        try {
            id = programareStore.create(newProgramare);
            AppUtils.getLocalProgramari().add(newProgramare);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

}
