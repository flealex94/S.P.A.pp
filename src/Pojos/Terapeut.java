package Pojos;

import Database.DaoImplementations.ClientDaoImpl;
import Database.DaoImplementations.TerapeutDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Terapeut", daoClass = TerapeutDaoImpl.class)
public class Terapeut {

    @DatabaseField(columnName = "idTerapeut", id = true)
    private int id;

    @DatabaseField(columnName = "Nume")
    private String nume;

    @DatabaseField(columnName = "Prenume")
    private String prenume;

    @DatabaseField(columnName = "Sex")
    private String sex;

    // constructors
    public Terapeut() {}

    public Terapeut(int id, String nume, String prenume, String sex) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.sex = sex;
    }

    public String toString() {
        return id + " - " + nume + " - " + prenume + " - " + sex;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
