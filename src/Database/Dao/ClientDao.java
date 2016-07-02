package Database.Dao;

import Pojos.Client;
import com.j256.ormlite.dao.Dao;

import java.util.List;

public interface ClientDao extends Dao<Client, Integer> {
    List<Client> getAllClients();
}
