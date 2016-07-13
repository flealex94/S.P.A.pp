package Database.Services;

import Database.DaoImplementations.TerapeutTerapieDaoImpl;
import Database.DaoImplementations.TerapieDaoImpl;
import Pojos.Terapeut;
import Pojos.TerapeutTerapie;
import Pojos.Terapie;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by teodor-stefu on 7/13/16.
 */
public class TerapieService {

    TerapieDaoImpl terapiiStore;
    TerapeutTerapieDaoImpl terapeutTerapieStore;

    public TerapieService(ConnectionSource conn) {

        try {
            terapiiStore = new TerapieDaoImpl(conn);
            terapeutTerapieStore = new TerapeutTerapieDaoImpl(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<Terapie> getAllTerapies() {
        System.out.println("Getting all the fking clients, mofo!");
        List<Terapie> ret = null;
        try {
            ret = terapiiStore.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public List<Terapie> getTerapiesForTerapeut(Terapeut terapeut) {
        List<Terapie> ret = new ArrayList<Terapie>();
        List<TerapeutTerapie> relations = null;
        Vector<Integer> terapieIndecses = new Vector<Integer>();
        try {
            System.out.println(terapeutTerapieStore.queryForAll());
            for (TerapeutTerapie relation : terapeutTerapieStore.queryForAll())
                if(relation.getIdTerapeut() == terapeut.getId())
                    terapieIndecses.add(relation.getIdTerapie());

            for (Terapie terapy : terapiiStore.queryForAll()) {
                for(Integer index : terapieIndecses) {
                    if(index == terapy.getId())
                        ret.add(terapy);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
