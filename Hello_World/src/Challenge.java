public class Challenge {

    public static void main(String[] args) {
        double firstDouble = 20.00;
        double secondDouble = 80.00;

        double result = (firstDouble + secondDouble) * 100.00;
        System.out.println("My value total is: " + result);

        double remainder = result % 40.00;
        System.out.println("The remainder is: " + remainder);

        boolean hasNoRemainder = remainder == 0.00;// ? true : false;
        System.out.println("hasNoRemainder = " + hasNoRemainder);

        String s = (hasNoRemainder) ? "There is no remainder" : "Got some remainder";
        System.out.println(s);


    }

}
