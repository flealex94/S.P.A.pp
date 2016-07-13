package Database.Services;

import Database.DaoImplementations.ClientDaoImpl;
import Database.DaoImplementations.SalaDaoImpl;
import Pojos.Client;
import Pojos.Sala;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by teodor-stefu on 7/13/16.
 */
public class SalaService {

    SalaDaoImpl salaStore;

    public SalaService(ConnectionSource conn) {

        try {
            salaStore = new SalaDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Sala> getAllClients() {
        System.out.println("Getting all the fking clients, mofo!");
        List<Sala> ret = null;
        try {
            ret = salaStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
