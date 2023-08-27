public class PerfectNumber {
    public static boolean isPerfectNumber(int number){
        if (number < 1){
            return false;
        }

        int divisorSum = 0;
        for(int i = 1; i <= number/2; i++){
            if (number % i == 0){
                divisorSum += i;
            }
        }

        return divisorSum == number;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }
}

