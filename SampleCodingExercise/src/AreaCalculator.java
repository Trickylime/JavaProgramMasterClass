public class AreaCalculator {
    public static double area(double radius){
        if (radius < 0){
            return -1.0;
        }

        double circleRadius = (radius * radius) * Math.PI;
        return circleRadius;
    }

    public static double area(double x, double y){
        if (x < 0 || y < 0){
            return -1.0;
        }

        double rectangleArea = x * y;
        return rectangleArea;
    }

    public static void main(String[] args) {
        System.out.println("The radius of the circle is " + area(5.0));
        System.out.println("The radius of the circle is " + area(-1));
        System.out.println("The area of the retangle is " + area(5.0, 4.0));
        System.out.println("The area of the retangle is " + area(-1.0, 4.0));
    }
}
