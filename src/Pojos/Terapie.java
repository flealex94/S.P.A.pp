package Pojos;


import Database.DaoImplementations.ClientDaoImpl;
import Database.DaoImplementations.TerapieDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;



@DatabaseTable(tableName = "Terapie", daoClass = TerapieDaoImpl.class)
public class Terapie {

    @DatabaseField(columnName = "idTerapie", id = true)
    private int id;

    @DatabaseField(columnName = "Nume")
    private String Nume;

    // constructors
    public Terapie() {}

    public Terapie(int id, String nume) {
        this.id = id;
        Nume = nume;
    }

    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }
}
