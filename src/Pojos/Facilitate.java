package Pojos;

import Database.DaoImplementations.FacilitateDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "Facilitate", daoClass = FacilitateDaoImpl.class)
public class Facilitate {

    @DatabaseField(columnName = "idFacilitate", id = true)
    private int id;

    @DatabaseField(columnName = "Nume", canBeNull = false)
    private String nume;

    public Facilitate() {
    }

    public Facilitate(String nume) {
        this.nume = nume;
    }

    public Facilitate(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
