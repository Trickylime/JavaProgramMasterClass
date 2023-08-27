public class SharedDigit {
    public static boolean hasSharedDigit(int x, int y){
        if (x < 10 || x > 99 || y < 10 || y > 99){
            return false;
        }

        int xFirstDigit = x / 10;
        int xSecondDigit = x % 10;

        int yFirstDigit = y / 10;
        int ySecondDigit = y % 10;

        if (xFirstDigit == yFirstDigit || xFirstDigit == ySecondDigit ||
                xSecondDigit == yFirstDigit || xSecondDigit == ySecondDigit){
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
    }
}
