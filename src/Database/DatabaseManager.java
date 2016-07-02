package Database;


import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseManager {
    static private DatabaseManager instance;
    String url, port, user;
    ConnectionSource conn;


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
            System.out.println("Connection to database ........... Success");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection to database ........... Fail");
        }
    }
}
