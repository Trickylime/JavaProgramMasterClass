public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString(-5));
    }
    public static String getDurationString(int seconds){
        if(seconds >= 0){
            int minute = seconds / 60;
            int remainderSeconds = seconds % 60;
            String timeString = getDurationString(minute, remainderSeconds);
            return timeString;
        }
        return "Invalid input";

    }

    public static String getDurationString(int minutes, int seconds){
        int hours = minutes / 60;
        int remainderMinutes = minutes % 60;
        String timeString = hours + "h " + remainderMinutes + "m " + seconds + "s";
        return timeString;
    }
}
