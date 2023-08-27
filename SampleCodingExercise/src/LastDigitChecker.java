public class LastDigitChecker {

    public static boolean isValid(int number){
        return number > 9 && number < 1001;
    }
    public static boolean hasSameLastDigit(int x, int y, int z){
        if(isValid(x) && isValid(y) && isValid(z)){
            x %= 10;
            y %= 10;
            z %= 10;

            return x == y || x == z || y == z;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(12, 12, 12));
    }
}
