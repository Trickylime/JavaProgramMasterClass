import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage(){

        int sum = 0;
        int avgCount = 0;
        double avgSum = 0;

        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();

            try{
                int validInput = Integer.parseInt(input);
                sum += validInput;
                avgCount++;

            } catch (NumberFormatException nfe){
                break;
            }
        }
        if(sum != 0){
           avgSum = (double) sum / avgCount;
        }

        System.out.println("SUM = " + (int)sum + " AVG = " + Math.round(avgSum));

    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
