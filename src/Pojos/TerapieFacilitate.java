package Pojos;

import Database.DaoImplementations.ClientDaoImpl;
import Database.DaoImplementations.TerapieFacilitateDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "TerapieFacilitate", daoClass = TerapieFacilitateDaoImpl.class)
public class TerapieFacilitate {

    @DatabaseField(columnName = "idTerapie", id = true)
    private int idTerapie;

    @DatabaseField(columnName = "idFacilitate", id = true)
    private int idFacilitate;

    // constructors
    public TerapieFacilitate() {}

    public TerapieFacilitate(int idTerapie, int idFacilitate) {
        this.idTerapie = idTerapie;
        this.idFacilitate = idFacilitate;
    }

    // setters and getters
    public int getIdTerapie() {
        return idTerapie;
    }

    public void setIdTerapie(int idTerapie) {
        this.idTerapie = idTerapie;
    }

    public int getIdFacilitate() {
        return idFacilitate;
    }

    public void setIdFacilitate(int idFacilitate) {
        this.idFacilitate = idFacilitate;
    }
}
