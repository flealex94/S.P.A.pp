/*
 * JENES
 * A time and memory efficient Java library for genetic algorithms and more 
 * Copyright (C) 2011 Intelligentia srl
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package GA;

/**
 * Abstractizarea unei programari fixate
 *
 *
 */
public class Programare {

    protected String name;

    //intervale disponibilitate
    protected int oraInceput;
    protected int oraSfarsit;

    public Programare(String name) {
        this.name = name;
    }

    public Programare(String name, int oraInceput, int oraSfarsit) {
        this.name = name;
        this.oraInceput = oraInceput;
        this.oraSfarsit = oraSfarsit;
    }


    public int getOraInceput() {
        return oraInceput;
    }

    public void setOraInceput(int oraInceput) {
        this.oraInceput = oraInceput;
    }

    public int getOraSfarsit() {
        return oraSfarsit;
    }

    public void setOraSfarsit(int oraSfarsit) {
        this.oraSfarsit = oraSfarsit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        return (hour >=oraInceput && hour <=oraSfarsit);
    }


    @Override
    public String toString() {
        return this.name;
    }


    public static final class Nobody extends Programare {

        public final static String NAME = "-";

        public Nobody() {
            super(Nobody.NAME);
        }

        public boolean isAvailable(Day day, int hour) {
            return false; //e liber
        }
    }
}
