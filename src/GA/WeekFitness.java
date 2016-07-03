package GA;

import jenes.chromosome.ObjectChromosome;
import jenes.population.Fitness;
import jenes.population.Individual;

import java.util.Arrays;
import java.util.Stack;

public class WeekFitness extends Fitness<ObjectChromosome> {
    private int meanHoursForWeek;
    private double meanHoursForDay;
    private Student[] students;
    private Week week;

    public WeekFitness(int objectives, boolean maximize, Student[] student, Week week, int targetHours) {
        super(objectives, maximize);
        this.students = student;
        this.week = week;
        this.meanHoursForWeek = targetHours;
        this.meanHoursForDay = (double)(this.meanHoursForWeek / week.getDayCount());
    }

    public void evaluate(Individual<ObjectChromosome> individual) {
        ObjectChromosome oc = (ObjectChromosome)individual.getChromosome();
        Day[] day = this.week.getDays();
        double[] dayCount = new double[this.week.getDayCount()];
        double[] studentCount = new double[this.students.length];
        Arrays.fill(studentCount, 0.0D);
        Stack stack = new Stack();

        int rmsForDay;
        for(rmsForDay = 0; rmsForDay < oc.length(); ++rmsForDay) {
            stack.push(oc.getGene(rmsForDay));
        }

        int numOfStudents;
        for(rmsForDay = 0; rmsForDay < day.length; ++rmsForDay) {
            Day d = day[rmsForDay];
            int rmsForStudent = d.getEnd() - d.getStart();
            int workTemporalSlice = 0;

            for(numOfStudents = 0; numOfStudents < rmsForStudent; ++numOfStudents) {
                ObjectChromosome.Gene i = (ObjectChromosome.Gene)stack.pop();
                Student s = (Student)i.getValue();
                String name = s.getName();
                if(!name.equalsIgnoreCase("-")) {
                    ++workTemporalSlice;
                    studentCount = this.countStudentHour(studentCount, name);
                }
            }

            dayCount[rmsForDay] = (double)workTemporalSlice;
        }

        double var15 = 0.0D;
        double var16 = 0.0D;

        for(numOfStudents = 0; numOfStudents < dayCount.length; ++numOfStudents) {
            dayCount[numOfStudents] -= this.meanHoursForDay;
            var15 += Math.pow(dayCount[numOfStudents], 2.0D);
        }

        numOfStudents = this.students.length;

        for(int var17 = 0; var17 < studentCount.length; ++var17) {
            studentCount[var17] -= (double)(this.meanHoursForWeek / numOfStudents);
            var16 += Math.pow(studentCount[var17], 2.0D);
        }

        var15 = Math.sqrt(var15 / this.meanHoursForDay);
        var16 = Math.sqrt(var16 / (double)(this.meanHoursForWeek / numOfStudents));
        individual.setScore(new double[]{var16, var15});
    }

    private double[] countStudentHour(double[] studentCount, String name) {
        for(int i = 0; i < this.students.length; ++i) {
            Student s = this.students[i];
            if(s.getName().equalsIgnoreCase(name)) {
                ++studentCount[i];
                break;
            }
        }

        return studentCount;
    }
}
