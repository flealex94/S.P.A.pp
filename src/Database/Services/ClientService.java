package Database.Services;

import Database.DaoImplementations.ClientDaoImpl;
import Pojos.Client;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by teodor-stefu on 7/13/16.
 */
public class ClientService {

    ClientDaoImpl clientStore;

    public ClientService(ConnectionSource conn) {

        try {
            clientStore = new ClientDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Client> getAllClients() {
        System.out.println("Getting all the fking clients, mofo!");
        List<Client> ret = null;
        try {
            ret = clientStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
