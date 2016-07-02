package Database.DaoImplementations;

import Database.Dao.TerapeutDao;
import Pojos.Terapeut;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by teodor on 02.07.2016.
 */
public class TerapeutDaoImpl extends BaseDaoImpl<Terapeut, Integer> implements TerapeutDao {

    // constructors
    public TerapeutDaoImpl(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Terapeut.class);
    }

}
