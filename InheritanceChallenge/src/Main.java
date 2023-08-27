public class Main {

    public static void main(String[] args) {

        Worker joe = new Worker("Joe", "01/01/1992");
        System.out.println(joe);

        Employee jon = new Employee("Jon", "02/01/1992",
                "01/05/2023");
        System.out.println(jon);

        SalriedEmployee ash = new SalriedEmployee("ash", "03/01/1992",
                "01/05/2023", 45_000);
        System.out.println(ash);

        System.out.println(joe.getAge());
        System.out.println("Ash's paycheck = £" + ash.collectPay());

        ash.retire();
        System.out.println("Ash's pension check = £ " + ash.collectPay());
    }
}
