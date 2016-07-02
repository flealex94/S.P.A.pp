package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Database.Dao.ProgramareDao;
import Pojos.Client;
import Pojos.Facilitate;
import Pojos.Programare;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;


public class ProgramareDaoImpl extends BaseDaoImpl<Programare, Integer> implements ProgramareDao {

    // constructors
    public ProgramareDaoImpl(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Programare.class);
    }
}
