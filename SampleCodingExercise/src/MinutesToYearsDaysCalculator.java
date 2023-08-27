public class MinutesToYearsDaysCalculator {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long years = minutes / 525600; // minutes in a year
            long days = (minutes % 525600) / 1440; // minutes in a day

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }

    }

    public static void main(String[] args) {
        printYearsAndDays(214);
    }
}
