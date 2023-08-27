public class SwitchChallenge {
    public static void main(String[] args) {
        char letterValue = 'B';

        switch(letterValue) {
            case 'A':
                System.out.println(letterValue + " in nato is: 'Able'");
                break;
            case 'B':
                System.out.println(letterValue + " in nato is: 'Baker'");
                break;
            case 'C':
                System.out.println(letterValue + " in nato is: 'Charlie'");
                break;
            case 'D':
                System.out.println(letterValue + " in nato is: 'Dog'");
                break;
            case 'E':
                System.out.println(letterValue + " in nato is: 'Easy'");
                break;
            default:
                System.out.println(letterValue + " letter not found.");
        }
    }
}
