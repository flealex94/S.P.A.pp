package Database.DaoImplementations;

import Database.Dao.ClientDao;
import Database.Dao.TerapieFacilitateDao;
import Pojos.Client;
import Pojos.Facilitate;
import Pojos.TerapieFacilitate;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

public class TerapieFacilitateDaoImpl extends BaseDaoImpl<TerapieFacilitate, Integer> implements TerapieFacilitateDao {

    // constructors
    public TerapieFacilitateDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, TerapieFacilitate.class);
    }

    // specific functions
    public List<TerapieFacilitate> getFacilitiesByTherapyId() {
        return null;
    }

    public List<TerapieFacilitate> getTherapiesByRequirementId() {
        return null;
    }
}
