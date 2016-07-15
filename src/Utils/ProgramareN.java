package Utils;


import GA.Day;

import java.util.HashMap;
import java.util.Vector;

public class ProgramareN {
    protected String name;

    String terapie;
    HashMap<String, Vector<Integer>> intervaleDisponibile;


    public ProgramareN(String name) {
        this.name = name;

    }


    public ProgramareN(String name, String terapie, HashMap<String, Vector<Integer>> intervaleDisponibile) {
        this.name = name;
        this.terapie = terapie;
        this.intervaleDisponibile = intervaleDisponibile;
    }

    public ProgramareN(String name, HashMap<String, Vector<Integer>> intervaleDisponibile) {
        this.name = name;
        this.intervaleDisponibile = intervaleDisponibile;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerapie() {
        return terapie;
    }

    public void setTerapie(String terapie) {
        this.terapie = terapie;
    }


    /**
     * Metoda ne spune daca un Client este disponibil
     *
     * @param day ziua saptamanii in care verificam disponibilitatea
     * @param hour ora din zi in care verificam daca este disponibil Clientul
     * Acest paramentru trebuie sa apartina intervalului 0-24
     * @return true daca Clientul este disponibil la acea ora,
     * else return false
     */
    public boolean isAvailable(Day day, int hour){
        Vector<Integer> ore = intervaleDisponibile.get(day.getPrintableName());

        return ore.contains(hour);
    }

}
