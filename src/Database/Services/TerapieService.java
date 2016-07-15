package Database.Services;

import Database.DaoImplementations.TerapeutTerapieDaoImpl;
import Database.DaoImplementations.TerapieDaoImpl;
import Pojos.Terapeut;
import Pojos.TerapeutTerapie;
import Pojos.Terapie;
import Utils.AppUtils;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TerapieService {

    private static TerapieService instance = null;
    ConnectionSource conn = null;
    TerapieDaoImpl terapiiStore;
    TerapeutTerapieDaoImpl terapeutTerapieStore;

    public static TerapieService getInstance(ConnectionSource conn) {
        if (instance == null)
            instance = new TerapieService(conn);
        return instance;
    }

    private TerapieService(ConnectionSource conn) {

        try {
            terapiiStore = new TerapieDaoImpl(conn);
            terapeutTerapieStore = new TerapeutTerapieDaoImpl(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<Terapie> getAllTerapies() {

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

    public int saveTerapie(Terapie terapie) {
        int id = -1;
        try {
            id = terapiiStore.create(terapie);
            AppUtils.getLocalTerapies().add(terapie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(id);
        return id;
    }
}
