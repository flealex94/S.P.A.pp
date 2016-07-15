package Database.Services;

import Database.DaoImplementations.TerapeutDaoImpl;
import Pojos.Terapeut;
import Utils.AppUtils;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;


public class TerapeutService {

    private static TerapeutService instance = null;
    ConnectionSource conn = null;
    TerapeutDaoImpl terapeutStore;

    public static TerapeutService getInstance(ConnectionSource conn) {
        if (instance == null)
            instance = new TerapeutService(conn);
        return instance;
    }

    private TerapeutService(ConnectionSource conn) {

        try {
            terapeutStore = new TerapeutDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Terapeut> getAllTerapeuts() {

        List<Terapeut> ret = null;
        try {
            ret = terapeutStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public int saveTerapeut(Terapeut newTerapeut) {
        int id = -1;
        try {
            id = terapeutStore.create(newTerapeut);
            AppUtils.getLocalTerapeuts().add(newTerapeut);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }

}
