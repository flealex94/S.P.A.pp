package GA;


public abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract boolean isBusy(Day var1, int var2);

    public String toString() {
        return this.name;
    }

    public static final class Nobody extends Student {
        public static final String NAME = "-";

        public Nobody() {
            super("-");
        }

        public boolean isBusy(Day day, int hour) {
            return false;
        }
    }
}