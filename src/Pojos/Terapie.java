package Pojos;


import Database.DaoImplementations.TerapieDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;



@DatabaseTable(tableName = "Terapie", daoClass = TerapieDaoImpl.class)
public class Terapie {

    @DatabaseField(columnName = "idTerapie", id = true)
    private int id;

    @DatabaseField(columnName = "Nume")
    private String nume;

    // constructors
    public Terapie() {}

    public Terapie(String nume) {
        this.nume = nume;
    }

    public Terapie(int id, String nume) {
        this.id = id;
        nume = nume;
    }

    public String toString() {
        return nume;
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

    public void setNume(String nume) { nume = nume;
    }

}
