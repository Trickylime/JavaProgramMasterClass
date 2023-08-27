public class DigitSumChallenge {

    public static int sumDigits(int number){

        int sum = 0;

        if (number < 0){
            return -1;
        } else if (number <= 9){
            return number;
        }

        while (number > 0){
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(1234));
        System.out.println(sumDigits(7));
        System.out.println(sumDigits(-125));
        System.out.println(sumDigits(323232));
    }
}
