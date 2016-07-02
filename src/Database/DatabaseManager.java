package Database;


import Database.Dao.ClientDao;
import Database.DaoImplementations.ClientDaoImpl;
import Pojos.Client;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

import java.sql.SQLException;


public class DatabaseManager {
    static private DatabaseManager instance;
    String url, port, user;
    ConnectionSource conn = null;
    ClientDao clientDao;

    public static DatabaseManager getInstance() {
        if (instance == null)
            instance = new DatabaseManager("localhost/SPA", "root", "teodor");
        return instance;
    }

    private DatabaseManager(String url, String user, String password) {
        url = url;
        port = port;
        user = user;
        try {
            conn = new JdbcConnectionSource("jdbc:mysql://" + url, user, password);
            clientDao = new ClientDaoImpl(conn);
            System.out.println("Connection to database ........... Success");

            System.out.println(clientDao.getAllClients());

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection to database ........... Fail");
        }
    }

}
