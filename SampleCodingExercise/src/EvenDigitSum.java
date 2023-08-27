public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        if (number < 0){
            return -1;
        }

        int evenSum = 0;
        int checkEven = 0;

        while(number != 0){
            checkEven = number % 10;
            number /= 10;
            if(checkEven % 2 == 0){
                evenSum += checkEven;
            }
        }

        return evenSum;
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }
}
