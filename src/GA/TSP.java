package GA;

import jenes.GeneticAlgorithm;
import jenes.chromosome.AlleleSet;
import jenes.chromosome.GenericAlleleSet;
import jenes.chromosome.ObjectChromosome;
import jenes.population.Fitness;
import jenes.population.Individual;
import jenes.population.Population;
import jenes.stage.operator.common.OnePointCrossover;
import jenes.stage.operator.common.SimpleMutator;
import jenes.stage.operator.common.TournamentSelector;
import jenes.tutorials.utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TSP {
    private static final int POPULATION_SIZE = 100;
    private static final int GENERATION_LIMIT = 1000;
    private static final int TASK_HOUR_PER_WEEK = 28;

    public static void GO() {
        Utils.printHeader();
        System.out.println();
        System.out.println("TUTORIAL 13:");
        System.out.println("This tutorial shows an other example in using ObjectChromosome in this case for task planning.");
        System.out.println();
        Student[] students = createStudentSet();
        Week week = new Week(9, 21);
        WeekFitness fitness = new WeekFitness(2, false, students, week, 28);
        fitness.setSortingMode(Fitness.SortingMode.CROWDING);
        Individual sample = generateIndividual(students, week);
        Population pop = new Population(sample, 100);
        GeneticAlgorithm ga = new GeneticAlgorithm(fitness, pop, 1000);
        ga.addStage(new TournamentSelector(3));
        ga.addStage(new OnePointCrossover(0.7D));
        ga.addStage(new SimpleMutator(0.02D));
        ga.setElitismStrategy(GeneticAlgorithm.ElitismStrategy.WORST);
        ga.evolve();
        Population.Statistics popStats = ga.getCurrentPopulation().getStatistics();
        jenes.GeneticAlgorithm.Statistics algoStats = ga.getStatistics();
        Population.Statistics.Group legals = popStats.getGroup(Population.LEGALS);
        System.out.println("Solution: ");
        System.out.println(prettyPrinter(legals.get(0), week));
        System.out.format("found in %d ms.\n", new Object[]{Long.valueOf(algoStats.getExecutionTime())});
        System.out.println();
        Utils.printStatistics(popStats);
    }

    private static Student[] createStudentSet() {
        Student[] students = new Student[]{new Student("Jack") {
            public boolean isBusy(Day day, int hour) {
                return (day == Day.MONDAY || day == Day.WEDNESDAY || day == Day.FRIDAY) && (hour == 8 || hour == 9 || hour == 10 || hour == 11);
            }
        }, new Student("Bill") {
            public boolean isBusy(Day day, int hour) {
                return (day == Day.MONDAY || day == Day.WEDNESDAY || day == Day.FRIDAY) && (hour == 15 || hour == 16 || hour == 17 || hour == 18);
            }
        }, new Student("Chris") {
            public boolean isBusy(Day day, int hour) {
                return (day == Day.TUESDAY || day == Day.THURSDAY || day == Day.SATURDAY) && (hour == 8 || hour == 9 || hour == 10 || hour == 11);
            }
        }, new Student("John") {
            public boolean isBusy(Day day, int hour) {
                return (day == Day.TUESDAY || day == Day.THURSDAY || day == Day.SATURDAY) && (hour == 15 || hour == 16 || hour == 17 || hour == 18);
            }
        }};
        return students;
    }

    private static Individual<ObjectChromosome> generateIndividual(Student[] s, Week w) {
        ArrayList genes = new ArrayList();

        for(int i = 0; i < w.getDayCount(); ++i) {
            Day d = w.getDay(i);
            List alphabet = getDayAlphabet(d, s);
            genes.addAll(alphabet);
        }

        return new Individual(new ObjectChromosome(genes), new double[0]);
    }

    private static List<AlleleSet<Student>> getDayAlphabet(Day d, Student[] student) {
        ArrayList alphabet = new ArrayList();

        for(int i = 0; i < d.getHourInDay(); ++i) {
            AlleleSet al = createAlleleSet(student, d, d.getStart() + i);
            alphabet.add(al);
        }

        return alphabet;
    }

    private static AlleleSet<Student> createAlleleSet(Student[] student, Day d, int hour) {
        HashSet freeStudents = new HashSet();
        freeStudents.add(new Student.Nobody());

        for(int k = 0; k < student.length; ++k) {
            if(!student[k].isBusy(d, hour)) {
                freeStudents.add(student[k]);
            }
        }

        return new GenericAlleleSet(freeStudents);
    }

    private static String prettyPrinter(Individual<ObjectChromosome> individual, Week w) {
        ObjectChromosome week = (ObjectChromosome)individual.getChromosome();
        byte magicNumber = 65;
        int minH = 24;
        int maxH = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        Day[] days = w.getDays();
        Day[] row = days;
        int i = days.length;

        int offset;
        for(offset = 0; offset < i; ++offset) {
            Day arr$ = row[offset];
            if(minH > arr$.getStart()) {
                minH = arr$.getStart();
            }

            if(maxH < arr$.getEnd()) {
                maxH = arr$.getEnd();
            }

            sb.append("| ");
            sb.append(arr$.getPrintableName());
            sb.append("\t");
        }

        sb.append("\n");

        int var18;
        for(var18 = 0; var18 < magicNumber; ++var18) {
            sb.append("-");
        }

        sb.append("\n");
        var18 = 0;

        for(i = minH; i < maxH; ++var18) {
            sb.append(i);
            sb.append("\t| ");
            offset = var18;
            Day[] var19 = days;
            int len$ = days.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Day d = var19[i$];
                if(d.isWorkingHour(i)) {
                    ObjectChromosome.Gene gene = week.getGene(offset);
                    Object value = gene.getValue();
                    sb.append(value.toString());
                } else {
                    sb.append("-");
                }

                sb.append("\t| ");
                offset += d.getHourInDay();
            }

            sb.append("\n");
            ++i;
        }

        for(i = 0; i < magicNumber; ++i) {
            sb.append("-");
        }

        sb.append("\n");
        return sb.toString();
    }
}