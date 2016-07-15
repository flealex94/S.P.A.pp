package Pojos;

import Database.DaoImplementations.SalaDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Sala", daoClass = SalaDaoImpl.class)
public class Sala {

    @DatabaseField(columnName = "idSala", id = true)
    private int id;

    @DatabaseField(columnName = "Nume")
    private String nume;

    // constructors
    public Sala() {}

    public Sala(String nume) {
        this.nume = nume;
    }

    public Sala(int id, String nume) {
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
