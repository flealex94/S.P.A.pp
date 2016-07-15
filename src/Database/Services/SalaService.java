package Database.Services;

import Database.DaoImplementations.SalaDaoImpl;
import Pojos.Sala;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;


public class SalaService {

    private static SalaService instance = null;
    ConnectionSource conn = null;
    SalaDaoImpl salaStore;

    public static SalaService getInstance(ConnectionSource conn) {
        if (instance == null)
            instance = new SalaService(conn);
        return instance;
    }

    private SalaService(ConnectionSource conn) {

        try {
            salaStore = new SalaDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Sala> getAllSalas() {

        List<Sala> ret = null;
        try {
            ret = salaStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }



}
