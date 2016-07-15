package Database.Services;

import Database.DaoImplementations.ClientDaoImpl;
import Pojos.Client;
import Utils.AppUtils;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by teodor-stefu on 7/13/16.
 */
public class ClientService {

    private static ClientService instance = null;
    ConnectionSource conn = null;
    ClientDaoImpl clientStore;

    public static ClientService getInstance(ConnectionSource conn){
        if (instance == null){
            instance = new ClientService(conn);
        }
        return instance;
    }

    private ClientService(ConnectionSource conn) {

        try {
            clientStore = new ClientDaoImpl(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Client> getAllClients() {

        List<Client> ret = null;
        try {
            ret = clientStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public int saveClient(Client newClient) {
        int id = -1;
        try {
            id = clientStore.create(newClient);
            AppUtils.getLocalClients().add(newClient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }
}
