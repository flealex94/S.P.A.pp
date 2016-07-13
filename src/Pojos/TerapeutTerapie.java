package Pojos;

import Database.DaoImplementations.ClientDaoImpl;
import Database.DaoImplementations.TerapeutTerapieDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "terapeut_terapie", daoClass = TerapeutTerapieDaoImpl.class)
public class TerapeutTerapie {

    @DatabaseField(columnName = "idTerapeut", id = true)
    private int idTerapeut;

    @DatabaseField(columnName = "idTerapie")
    private int idTerapie;

    // constructors
    public TerapeutTerapie() {}

    public TerapeutTerapie(int idTerapeut, int idTerapie) {
        this.idTerapeut = idTerapeut;
        this.idTerapie = idTerapie;
    }

    // setters and getters
    public int getIdTerapeut() {
        return idTerapeut;
    }

    public void setIdTerapeut(int idTerapeut) {
        this.idTerapeut = idTerapeut;
    }

    public int getIdTerapie() {
        return idTerapie;
    }

    public void setIdTerapie(int idTerapie) {
        this.idTerapie = idTerapie;
    }
}
