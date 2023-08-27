import java.util.Scanner;

public class MinAndMaxChallenge {
    public static void main(String[] args) {

        int minNum = 0;
        int maxNum = 0;
        int loopCount = 0;

        boolean isNumber = true;

        Scanner scanner = new Scanner(System.in);

        do{
            if(loopCount > 0){
                System.out.println("Minimum number entered is: " + minNum);
                System.out.println("Maximum number entered is: " + maxNum);
            }
            System.out.println("Please enter a whole number: ");
            String nextEntry = scanner.nextLine();

            try {
                int currentNum = Integer.parseInt(nextEntry);
                if(loopCount == 0 || currentNum < minNum){
                    minNum = currentNum;
                }
                if (loopCount == 0 || currentNum > maxNum){
                    maxNum = currentNum;
                }
                loopCount++;

            } catch (NumberFormatException badUserData){
                System.out.println("Invalid Input, exiting loop");
                isNumber = false;
            }
        } while (isNumber);




    }
}
