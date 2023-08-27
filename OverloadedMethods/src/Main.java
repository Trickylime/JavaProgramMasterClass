public class Main {
    public static void main(String[] args) {
        double inchInput = 68;
        double feetInput = 5;
        double withInchInput = 8;
        System.out.println(inchInput + " inches = " + convertToCentimeters((int)inchInput) + " centimeters");
        System.out.println(feetInput + " feet " + withInchInput + " inches = " + convertToCentimeters((int)feetInput, (int)withInchInput));
    }

    public static double convertToCentimeters(int heightInInches){
        return heightInInches *= 2.54;
    }

    public static double convertToCentimeters(int heightInFeet, int remaindingInches){
        return convertToCentimeters((heightInFeet * 12) + remaindingInches);
    }
}
