package Database.Services;

import Database.DaoImplementations.TerapeutDaoImpl;
import Database.DaoImplementations.TerapieDaoImpl;
import Pojos.Terapeut;
import Pojos.Terapie;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by teodor-stefu on 7/13/16.
 */
public class TerapeutService {

    TerapeutDaoImpl terapeutStore;

    public TerapeutService(ConnectionSource conn) {

        try {
            terapeutStore = new TerapeutDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Terapeut> getAllTerapeuts() {
        System.out.println("Getting all the fking clients, mofo!");
        List<Terapeut> ret = null;
        try {
            ret = terapeutStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
