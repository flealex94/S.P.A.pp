package Database;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;


public class DatabaseManager {
    static private DatabaseManager instance;
    String url, port, user;
    ConnectionSource conn = null;

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

    public static void setInstance(DatabaseManager instance) {
        DatabaseManager.instance = instance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ConnectionSource getConn() {
        return conn;
    }

    public void setConn(ConnectionSource conn) {
        this.conn = conn;
    }
}
