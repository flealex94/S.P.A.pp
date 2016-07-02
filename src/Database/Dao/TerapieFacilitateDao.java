package Database.Dao;

import Pojos.Client;
import Pojos.TerapieFacilitate;
import com.j256.ormlite.dao.Dao;

import java.util.List;

/**
 * Created by teodor on 02.07.2016.
 */
public interface TerapieFacilitateDao extends Dao<TerapieFacilitate, Integer> {
    List<TerapieFacilitate> getFacilitiesByTherapyId();
    List<TerapieFacilitate> getTherapiesByRequirementId();
}
