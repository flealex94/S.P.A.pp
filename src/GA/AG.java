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

import Pojos.Client;
import Pojos.Terapeut;
import Pojos.Terapie;
import Utils.AppUtils;
import jenes.GeneticAlgorithm;
import jenes.GeneticAlgorithm.ElitismStrategy;
import jenes.chromosome.AlleleSet;
import jenes.chromosome.GenericAlleleSet;
import jenes.chromosome.ObjectChromosome;
import jenes.chromosome.ObjectChromosome.Gene;
import jenes.population.Fitness.SortingMode;
import jenes.population.Individual;
import jenes.population.Population;
import jenes.population.Population.Statistics;
import jenes.population.Population.Statistics.Group;
import jenes.stage.operator.common.OnePointCrossover;
import jenes.stage.operator.common.SimpleMutator;
import jenes.stage.operator.common.TournamentSelector;

import java.util.*;

/**
 * This class set-up the algorithm for execution, it includes the main method.
 *
 * @since 2.1
 */
public class AG {

    /**
     * Standard parameters for a GeneticAlgorithm
     */
    private static final int POPULATION_SIZE = 70;
    private static final int GENERATION_LIMIT = 100;
    private static final int TASK_HOUR_PER_WEEK = 10;

    public static Object[][] Optimizare() {
        Object[][] data = null;

        if (AppUtils.getProgramariNecalculate().isEmpty())
            System.out.println("Nu exista programari noi pentru saptamana aceasta!");
        else {
            Programare[] programari = createProgramareSet();

            //create the week and assign to each day the given operativity hour interval
            Week week = new Week(9, 19);

            //create the fitness for the problem
            WeekFitness fitness = new WeekFitness(2, false, programari, week, TASK_HOUR_PER_WEEK);
            fitness.setSortingMode(SortingMode.CROWDING);

            //create the sample individual for the population
            Individual<ObjectChromosome> sample = generateIndividual(programari, week);
            Population<ObjectChromosome> pop = new Population<ObjectChromosome>(sample, POPULATION_SIZE);

            //create the genetic algorithm in a usual way
            GeneticAlgorithm<ObjectChromosome> ga =
                    new GeneticAlgorithm<ObjectChromosome>(fitness, pop, GENERATION_LIMIT);
            ga.addStage(new TournamentSelector<ObjectChromosome>(3));
            ga.addStage(new OnePointCrossover<ObjectChromosome>(0.7));
            ga.addStage(new SimpleMutator<ObjectChromosome>(0.02));

            ga.setElitismStrategy(ElitismStrategy.WORST);
            ga.evolve();

            //...get statistics
            Statistics<ObjectChromosome> popStats = ga.getCurrentPopulation().getStatistics();
            GeneticAlgorithm.Statistics algoStats = ga.getStatistics();

            Group<ObjectChromosome> legals = popStats.getGroup(Population.LEGALS);
            Individual<ObjectChromosome> individual = legals.get(0);

            System.out.println("Solutie: ");
            System.out.println(prettyPrinter(individual, week));
            System.out.format("... gasita in %d ms.\n", algoStats.getExecutionTime());
            System.out.println();

            //Utils.printStatistics(popStats);

            data = extractObjFromIndividual(individual, week);
        }
        return data;
    }

    /**
     * Cream setul de programari ce urmeaza a fi procesate
     *
     * @return
     */
    private static Programare[] createProgramareSet() {
        ArrayList<Programare> programares = AppUtils.getProgramariNecalculate();
        Programare[] programari = new Programare[programares.size()];
        for (int i = 0; i < programares.size(); i++) {
            programari[i] = programares.get(i);
        }

        return programari;
    }

    /**
     * This method creates a template of Individual for the first population to evolve.
     *
     * @param p colectie de programari ce urmeaza a fi procesate
     * @param w saptamana in care se realizeaza planificarea
     * @return un Individual format dintr-un ObjectChromosome unde fiecare gena
     * reprezinta o ora intr-o zi in care Clientul este programat
     * sa beneficieze de terapia dorita.
     */
    private static Individual<ObjectChromosome> generateIndividual(Programare[] p, Week w) {

        List<AlleleSet> genes = new ArrayList<AlleleSet>();
        for (int i = 0; i < w.getDayCount(); i++) {    //create the alphabet for the week
            Day d = w.getDay(i);

            //...each hour is an AlleleSet
            List<AlleleSet<Programare>> alphabet = getDayAlphabet(d, p);
            genes.addAll(alphabet);
        }

        return new Individual<ObjectChromosome>(new ObjectChromosome(genes));
    }

    /**
     * Metoda creeaza alfabetul de Clienti pentru fiecare ora a zilei furnizate
     *
     * @param programare colectie de programari ce urmeaza a fi procesate
     *                   (candidati pentru programare)
     * @return o lista ce contine alfabetul pentru fiecare interval de timp fezabil
     */
    private static List<AlleleSet<Programare>> getDayAlphabet(Day d, Programare[] programare) {

        List<AlleleSet<Programare>> alphabet = new ArrayList<AlleleSet<Programare>>();
        for (int i = 0; i < d.getHourInDay(); i++) {
            AlleleSet<Programare> al = createAlleleSet(programare, d, d.getStart() + i);
            alphabet.add(al); //add the alphabet for hour start+i
        }

        return alphabet;
    }

    /**
     * Aceasta metoda creeaza un AlleleSet ce corespunde cu intervalele de disponibilitate ale Clientului
     *
     * @param programare colectie de programari ce sunt verificate
     * @param hour       ora din zi in care verificam daca sunt disponibili Clientii
     * @return un AlleleSet cu Clientii diponibili la acea ora din zi
     */
    private static AlleleSet<Programare> createAlleleSet(Programare[] programare, Day d, int hour) {

        Set<Programare> freeProgramares = new HashSet<Programare>();

        freeProgramares.add(new Programare.Nobody());

        for (int k = 0; k < programare.length; k++) {
            if (programare[k].isAvailable(d, hour)) {
                freeProgramares.add(programare[k]);
            }
        }

        // setul de alele este format din toti cleintii disponibil la un interval de timp dat
        return new GenericAlleleSet<Programare>(freeProgramares);
    }


    private static String prettyPrinter(Individual<ObjectChromosome> individual, Week w) {

        ObjectChromosome week = individual.getChromosome();


        int magicNumber = 65;


        int minH = 24;
        int maxH = 1;

        StringBuilder sb = new StringBuilder();
        sb.append("\t");

        Day[] days = w.getDays();
        for (Day d : days) {
            if (minH > d.getStart()) {
                minH = d.getStart();
            }

            if (maxH < d.getEnd()) {
                maxH = d.getEnd();
            }


            sb.append("| ");
            sb.append(d.getPrintableName());
            sb.append("\t");
        }
        sb.append("\n");


        for (int i = 0; i < magicNumber; i++) {
            sb.append("-");
        }
        sb.append("\n");

        int row = 0;
        for (int i = minH; i < maxH; i++, row++) {

            sb.append(i);
            sb.append("\t| ");

            int offset = row;
            for (Day d : days) {
                if (d.isWorkingHour(i)) {
                    int idx = offset;

                    Gene gene = week.getGene(idx);
                    Object value = gene.getValue();
                    sb.append(value.toString());

                } else {
                    sb.append(Programare.Nobody.NAME);
                }
                sb.append("\t| ");
                offset += d.getHourInDay();
            }

            sb.append("\n");
        }

        for (int i = 0; i < magicNumber; i++) {
            sb.append("-");
        }
        sb.append("\n");

        return sb.toString();
    }

    public static Object[][] extractObjFromIndividual(Individual<ObjectChromosome> individual, Week w) {

        ObjectChromosome week = individual.getChromosome();

        int minH = 24;
        int maxH = 1;

        Day[] days = w.getDays();
        for (Day d : days) {
            if (minH > d.getStart()) {
                minH = d.getStart();
            }

            if (maxH < d.getEnd()) {
                maxH = d.getEnd();
            }
        }

        Object[][] data = new Object[maxH - minH][8];


        int row = 0;
        for (int i = minH; i < maxH; i++, row++) {

            StringBuilder sb = new StringBuilder();
            sb.append(i).append("-").append(i + 1);
            data[row][0] = sb.toString();
            sb.setLength(0);

            //ProgramareService programareService =  ProgramareService.getInstance(DatabaseManager.getInstance().getConn());
            int offset = row;
            int j = 1;
            for (Day d : days) {
                if (d.isWorkingHour(i)) {
                    int idx = offset;

                    Gene gene = week.getGene(idx);
                    String numeClient = gene.getValue().toString();

                    if (!numeClient.equalsIgnoreCase(Programare.Nobody.NAME)) {

                        Terapie terapie = AppUtils.getTerapieByClientName(numeClient);
                        Terapeut terapeut = AppUtils.getTerapeutForTerapie(terapie.toString());
                        Client client = AppUtils.getClientByName(numeClient);
                        Pojos.Programare programare = new Pojos.Programare(1,client.getId(),terapeut.getId(),terapie.getId(),new Date());
                        //programareService.saveProgramare(programare);
                        //System.out.println("Programare adaugata in BD!");

                        sb.append(terapeut.toString()).append(" +\n").append(numeClient).append("\n=============\n").append(terapie.toString());
                    } else {
                        sb.append(Programare.Nobody.NAME);
                    }
                    data[row][j] = sb.toString();
                    sb.setLength(0);
                } else {
                    data[row][j] = Programare.Nobody.NAME;
                }
                j++;
                offset += d.getHourInDay();
            }

        }

        return data;
    }


    private static void print(Individual<ObjectChromosome> individual, Week w) {

        ObjectChromosome week = individual.getChromosome();

        int minH = 24;
        int maxH = 1;

        Day[] days = w.getDays();
        for (Day d : days) {
            if (minH > d.getStart()) {
                minH = d.getStart();
            }

            if (maxH < d.getEnd()) {
                maxH = d.getEnd();
            }
        }

        //renders the rows in the table
        int row = 0;
        for (int i = minH; i < maxH; i++, row++) {

            int offset = row;
            for (Day d : days) {
                if (d.isWorkingHour(i)) {
                    int idx = offset;

                    Gene gene = week.getGene(idx);
                    Object value = gene.getValue();
                    System.out.println(value.toString());

                } else {

                }

                offset += d.getHourInDay();
            }


        }


    }
}
