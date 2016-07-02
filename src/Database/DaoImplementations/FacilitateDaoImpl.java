package Database.DaoImplementations;


import Database.Dao.FacilitateDao;
import Pojos.Client;
import Pojos.Facilitate;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

import java.sql.SQLException;

public class FacilitateDaoImpl extends BaseDaoImpl<Facilitate, Integer> implements FacilitateDao{


    // constructors
    public FacilitateDaoImpl(ConnectionSource connectionSource)
            throws SQLException {
        super(connectionSource, Facilitate.class);
    }

}
