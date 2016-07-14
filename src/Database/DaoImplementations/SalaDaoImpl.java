package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Database.Dao.SalaDao;
import Pojos.Client;
import Pojos.Facilitate;
import Pojos.Sala;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by teodor on 02.07.2016.
 */
public class SalaDaoImpl extends BaseDaoImpl<Sala, Integer> implements SalaDao {

    // constructors
    public SalaDaoImpl(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Sala.class);
    }
}
