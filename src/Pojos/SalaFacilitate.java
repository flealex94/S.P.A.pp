package Pojos;

import Database.DaoImplementations.ClientDaoImpl;
import Database.DaoImplementations.SalaFacilitateDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SalaFacilitate", daoClass = SalaFacilitateDaoImpl.class)
public class SalaFacilitate {

    @DatabaseField(columnName = "idSala", id = true)
    private int idSala;

    @DatabaseField(columnName = "idFacilitate", id = true)
    private int idFacilitate;

    // constructors
    public SalaFacilitate() {}

    public SalaFacilitate(int idSala, int idFacilitate) {
        this.idSala = idSala;
        this.idFacilitate = idFacilitate;
    }

    // setters and getters
    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdFacilitate() {
        return idFacilitate;
    }

    public void setIdFacilitate(int idFacilitate) {
        this.idFacilitate = idFacilitate;
    }


}
