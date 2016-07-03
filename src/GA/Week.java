package GA;

public class Week {
    private Day[] days = Day.values();
    private int weekHours = 0;

    public Week(int hourStart, int hourEnd) {
        Day[] arr$ = this.days;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Day d = arr$[i$];
            d.setRange(hourStart, hourEnd);
            this.weekHours += d.getHourInDay();
        }

    }

    public Week() {
        Day[] arr$ = this.days;
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Day d = arr$[i$];
            this.weekHours += d.getHourInDay();
        }

    }

    public Day[] getDays() {
        return this.days;
    }

    public Day getDay(int index) {
        return this.days[index];
    }

    public int getDayCount() {
        return this.days.length;
    }

    public int getWeekHours() {
        return this.weekHours;
    }
}
