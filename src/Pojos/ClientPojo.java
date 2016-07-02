package Pojos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by teodor on 02.07.2016.
 */

@DatabaseTable(tableName = "Client")
public class ClientPojo {
    @DatabaseField(id = true)
    private int id;

    @DatabaseField(columnName = "Nume", canBeNull = false)
    private String nume;

    @DatabaseField(columnName = "Prenume", canBeNull = false)
    private String prenume;

    @DatabaseField(columnName = "Telefon", canBeNull = false)
    private String telefon;

    @DatabaseField(columnName = "Email", canBeNull = false)
    private String email;

    @DatabaseField(columnName = "Sex", canBeNull = false)
    private String sex;

    public ClientPojo() {
        // ORMLite needs a no-arg constructor
    }

    public ClientPojo(int id, String nume, String prenume, String telefon, String email, String sex) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.sex = sex;
    }

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String toString() {
        return id + " " + nume + " "  + prenume;
    }
}
