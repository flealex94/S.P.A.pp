package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Database.Dao.SalaFacilitateDao;
import Pojos.Client;
import Pojos.Facilitate;
import Pojos.SalaFacilitate;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by teodor on 02.07.2016.
 */
public class SalaFacilitateDaoImpl extends BaseDaoImpl<SalaFacilitate, Integer> implements SalaFacilitateDao {

    // constructors
    public SalaFacilitateDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SalaFacilitate.class);
    }

}
