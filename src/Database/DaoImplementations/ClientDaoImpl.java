package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Pojos.Client;
import com.j256.ormlite.dao.*;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.*;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.ObjectFactory;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;


public class ClientDaoImpl extends BaseDaoImpl<Client, Integer> implements ClientDao {

    // constructors
    public ClientDaoImpl(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Client.class);
    }

}

