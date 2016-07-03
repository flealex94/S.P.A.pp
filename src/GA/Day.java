package GA;

/**
 * Created by flea on 03-Jul-16.
 */
public enum Day {
    MONDAY("Mon", 9, 21),
    TUESDAY("Tue", 9, 21),
    WEDNESDAY("Wed", 9, 21),
    THURSDAY("Thu", 9, 21),
    FRIDAY("Fri", 9, 21),
    SATURDAY("Sat", 9, 21),
    SUNDAY("Sun", 9, 21);

    private int start;
    private int end;
    private String printableName;

    private Day(String printableName, int start, int end) {
        this.printableName = printableName;
        this.start = start;
        this.end = end;
    }

    public String getPrintableName() {
        return this.printableName;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setRange(int hourStart, int hourEnd) {
        if(hourStart <= hourEnd && hourStart > 0 && hourStart <= 24 && hourEnd > 0 && hourEnd <= 24) {
            this.start = hourStart;
            this.end = hourEnd;
        } else {
            throw new AssertionError("Invalid time range!");
        }
    }

    public int getHourInDay() {
        return this.end - this.start;
    }

    public boolean isWorkingHour(int hour) {
        return hour >= this.start && hour <= this.end;
    }

    public String toString() {
        return this.getPrintableName();
    }
}