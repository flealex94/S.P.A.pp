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

import jenes.chromosome.ObjectChromosome;
import jenes.chromosome.ObjectChromosome.Gene;
import jenes.population.Fitness;
import jenes.population.Individual;

import java.util.Arrays;
import java.util.Stack;

/**
 * Rappresent the fitness function used to evaluate the quality of a solution
 * founded by the algorithm.
 *
 * @since 2.1
 */
public class WeekFitness extends Fitness<ObjectChromosome> {
    /** mean hours in the week */
    private int meanHoursForWeek;
    /** mean hours spent per day */
    private double meanHoursForDay;
    /** the set of programares considered by the problem */
    private Programare[] programares;
    /** the week */
    private Week week;

    /**
     * Creeaza o noua functie fitnez cu numarul dat de obiective si un paramentru ce indica
     * daca functia trebuie maximizata sau minimizata
     *
     * @param objectives numbers of objective
     * @param maximize when <tt>true</tt> the algorithm will find solution with maximum score;
     * false otherwise
     * @param programare the array of programares that lives in the house
     * @param week the week to evaluate
     * @param targetHours the amount of hours programare have to work
     */
    public WeekFitness(int objectives, boolean maximize, Programare[] programare, Week week, int targetHours) {
        super(objectives, maximize);
        
        this.programares = programare;
        this.week = week;
        this.meanHoursForWeek = targetHours;
        this.meanHoursForDay = this.meanHoursForWeek / week.getDayCount();
    }

    @Override
    public void evaluate(Individual<ObjectChromosome> individual) {
        ObjectChromosome oc = individual.getChromosome();

        Day[] day = this.week.getDays();

        double[] dayCount = new double[this.week.getDayCount()];
        double[] clieentCount = new double[this.programares.length];

        //set to 0 the values of count of how many hours each student work
        Arrays.fill(clieentCount, 0.0);

        Stack<ObjectChromosome.Gene> stack = new Stack<ObjectChromosome.Gene>();
        for (int i = 0; i < oc.length(); i++) {
            stack.push(oc.getGene(i));
        }

        for (int i = 0; i < day.length; i++) {
            Day d = day[i];
            int hours = d.getEnd() - d.getStart();
            int workTemporalSlice = 0; //how many hours of work in day i

            for (int j = 0; j < hours; j++) {
                Gene gene = stack.pop();
                Programare s = (Programare) gene.getValue();

                String name = s.getName();
                if (!name.equalsIgnoreCase(Programare.Nobody.NAME)) {
                    workTemporalSlice++;
                    //add a work's hour to a student with that name
                    clieentCount = this.countStudentHour(clieentCount, name);
                }
            }

            dayCount[i] = workTemporalSlice;
        }

        double rmsForDay = 0.0;
        double rmsForStudent = 0.0;

        //calculate the rms for every day and every student
        for (int i = 0; i < dayCount.length; i++) {
            dayCount[i] = dayCount[i] - this.meanHoursForDay;
            rmsForDay = rmsForDay + Math.pow(dayCount[i], 2);
        }
        
        int numOfStudents = this.programares.length;
        for (int i = 0; i < clieentCount.length; i++) {
            clieentCount[i] = clieentCount[i] - (this.meanHoursForWeek / numOfStudents);
            rmsForStudent = rmsForStudent + Math.pow(clieentCount[i], 2);
        }


        rmsForDay = Math.sqrt(rmsForDay / this.meanHoursForDay);
        rmsForStudent = Math.sqrt(rmsForStudent / (this.meanHoursForWeek / numOfStudents));

        //set as first objective the rmsForStudent and second the rmsForDay
        individual.setScore(rmsForStudent, rmsForDay);
    }

    private double[] countStudentHour(double[] studentCount, String name) {
        for (int i = 0; i < this.programares.length; i++) {
            Programare s = this.programares[i];
            if (s.getName().equalsIgnoreCase(name)) {
                studentCount[i]++;
                break;
            }
        }

        return studentCount;
    }
}
