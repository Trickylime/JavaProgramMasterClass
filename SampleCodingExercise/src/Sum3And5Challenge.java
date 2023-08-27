public class Sum3And5Challenge {
    public static void main(String[] args) {

        int counter = 0;
        int sum = 0;

        for(int i = 1; counter < 5 && i <= 1000; i++ ){
            if(i % 3 == 0 && i % 5 == 0)    {
                System.out.println("The number " + i + " meets the conditions");
                counter++;
                sum += i;
            }
        }

        System.out.println("The sum of the results is: " + sum);

    }
}
