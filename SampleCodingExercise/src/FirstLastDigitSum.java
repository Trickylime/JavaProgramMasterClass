public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int number){
        if (number < 0){
            return -1;
        }

        int firstNumber = 0;
        int lastNumber = 0;

        lastNumber = number % 10;

        while (number > 9){
            number /= 10;
        }

        firstNumber = number;
        return firstNumber + lastNumber;
    }

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));
    }
}
