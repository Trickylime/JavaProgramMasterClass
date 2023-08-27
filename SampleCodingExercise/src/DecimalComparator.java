public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double check1, double check2){
        int myFirstCheck = (int)(check1 * 1000);
        int mySecondCheck = (int)(check2 * 1000);
        System.out.println("Check 1 = " + myFirstCheck);
        System.out.println("Check 2 = " + mySecondCheck);
        return myFirstCheck - mySecondCheck == 0;
    }

    public static void main(String[] args) {
        System.out.println(
        areEqualByThreeDecimalPlaces(-1.876, -1.875));
    }

}
