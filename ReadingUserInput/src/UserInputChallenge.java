import java.util.Scanner;

public class UserInputChallenge {
    public static void main(String[] args) {
        System.out.println(getInputFromScanner(5));
    }

    public static String getInputFromScanner(int number) {

        Scanner scanner = new Scanner(System.in);

        int validNumbers = 0;
        int sum = 0;

        while (validNumbers < number) {
            String numberInput;
            System.out.println("Enter number #" + (validNumbers + 1) + ":");

            try {
                numberInput = scanner.nextLine();
                sum += Integer.parseInt(numberInput);
                validNumbers++;
            } catch (NumberFormatException badUserData){
                System.out.println("Invalid Input");
            }

        }
        return "The sum of your inputs are: " + sum;
    }

}
