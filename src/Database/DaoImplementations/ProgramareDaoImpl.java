package Database.DaoImplementations;

import Database.Dao.ProgramareDao;
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
