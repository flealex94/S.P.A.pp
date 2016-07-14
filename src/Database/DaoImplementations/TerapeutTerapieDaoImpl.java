package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Database.Dao.TerapeutTerapieDao;
import Pojos.Client;
import Pojos.Facilitate;
import Pojos.TerapeutTerapie;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by teodor on 02.07.2016.
 */
public class TerapeutTerapieDaoImpl extends BaseDaoImpl<TerapeutTerapie, Integer> implements TerapeutTerapieDao {

    //constructors
    public TerapeutTerapieDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, TerapeutTerapie.class);
    }
}
