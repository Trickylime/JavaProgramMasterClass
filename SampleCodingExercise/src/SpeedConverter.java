public class SpeedConverter {

    public static void main(String[] args) {

//        final Scanner in = new Scanner(System.in);
//        String entry;
//        while (true)
//        {
//            entry = in.next();
//            if(entry.equalsIgnoreCase("stop"))
//                break;
//
//            System.out.println(toMilesPerHour(Double.parseDouble(entry)));
//        }

        System.out.println(toMilesPerHour(10.25));
        printConversion(1.5);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1L;
        } else if (kilometersPerHour > 0) {
            double milesPerHour = kilometersPerHour * 0.621371192;
            return Math.round(milesPerHour);
        }
        return 0;
    }

    public static void printConversion(double kilometersPerHour) {
        //double kph = kilometersPerHour;
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            double milesPerHour = kilometersPerHour / 1.609;
            milesPerHour = Math.round(milesPerHour);
            System.out.println(kilometersPerHour + " km/h = " + (long)milesPerHour + " mi/h");
        }
    }
}
