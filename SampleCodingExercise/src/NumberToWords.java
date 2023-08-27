public class NumberToWords {

    public static void main(String[] args) {
        numberToWords(123000);
        System.out.println("reverse count is = " + reverse(1230));
        System.out.println("digit count is = " + getDigitCount(0));
    }
    public static void numberToWords(int number){
        if (number < 0){
            System.out.println("Invalid Value");
        }

        int count = getDigitCount(number);
        int print = 0;

        number = reverse(number);

        for (int i = 0; i < count; i++) {
            print = number % 10;
            switch (print) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            number /= 10;

        }
    }

    public static int reverse(int number){
        int reverse = 0;
        int lastDigit = 0;

        while (number != 0){
            lastDigit = number % 10;
            reverse += lastDigit;
            reverse *= 10;
            number /= 10;
        }

        return reverse /= 10;
    }

    public static int getDigitCount(int number){
        if(number < 0){
            return -1;
        }

        int digitCount = 0;

        do{
            digitCount++;
            number /= 10;
        } while (number > 0);

        return digitCount;
    }
}
