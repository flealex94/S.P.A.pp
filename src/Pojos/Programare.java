package Pojos;

import Database.DaoImplementations.ProgramareDaoImpl;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Programare", daoClass = ProgramareDaoImpl.class)
public class Programare {
    @DatabaseField(columnName = "idProgramare", id = true)
    private int id;

    @DatabaseField(columnName = "idSala", id = true)
    private int idSala;

    @DatabaseField(columnName = "idClient", canBeNull = false)
    private int idClient;

    @DatabaseField(columnName = "idTerapeut", canBeNull = false)
    private int idTerapeut;

    @DatabaseField(columnName = "idTerapie", canBeNull = false)
    private int idTerapie;

    @DatabaseField(columnName = "data", canBeNull = false)
    private Date dataProgramare;

    //intervale disponibilitate

    protected int oraInceput;
    protected int oraSfarsit;
    // constructors
    public Programare() {}


    public Programare(int id, int idSala, int idClient, int idTerapeut, int idTerapie, Date dataProgramare) {
        this.id = id;
        this.idSala = idSala;
        this.idClient = idClient;
        this.idTerapeut = idTerapeut;
        this.idTerapie = idTerapie;
        this.dataProgramare = dataProgramare;
    }

    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

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

    public Date getDataProgramare() {
        return dataProgramare;
    }

    public void setDataProgramare(Date dataProgramare) {
        this.dataProgramare = dataProgramare;
    }
}
