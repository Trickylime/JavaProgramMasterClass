public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1320));

    }
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int lastDigit = 0;
        int temp = number;

        while (temp != 0){
            lastDigit = temp % 10;
            reverse += lastDigit;
            reverse *= 10;
            temp /= 10;
        }

        reverse /= 10;

        if(number == reverse){
            return true;
        } else {
            return false;
        }
    }
}


