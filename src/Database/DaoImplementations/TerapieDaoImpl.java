package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Database.Dao.TerapieDao;
import Pojos.Client;
import Pojos.Facilitate;
import Pojos.Terapie;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by teodor on 02.07.2016.
 */
public class TerapieDaoImpl extends BaseDaoImpl<Terapie, Integer> implements TerapieDao {

    //constructors
    public TerapieDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Terapie.class);
    }

}
