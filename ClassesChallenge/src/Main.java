public class Main {
    public static void main(String[] args) {
//        Account jacksAccount = new Account("12345", 1000.00,
//                "Jack Jackson", "JackJackingson@Jackson.com",
//                "+61 746988746");
        ///account section of code
//        Account jacksAccount = new Account();
//
//        System.out.println(jacksAccount.getAccountNumber());
//        System.out.println(jacksAccount.getAccountBalance());
//
//        jacksAccount.deposit(100.00);
//        jacksAccount.withdraw(50.00);
//
//        Account timsAccount = new Account("Time", "tim@email.com",
//                "12345");
//        System.out.println("AccountNo: " + timsAccount.getAccountNumber() + "; name " +
//                timsAccount.getCustomerName());

        /// constructor challenge section - using Customer class.

        Customer jack = new Customer("Jack", 2_000_000, "Jack@gmail.com");
        System.out.println("Customer name: " + jack.getName() + " credit limit: " + jack.getCreditLimit()
        + " email: " + jack.getEmail());

        Customer John = new Customer();
        System.out.println("Customer name: " + John.getName() + " credit limit: " + John.getCreditLimit()
                + " email: " + John.getEmail());

        Customer Jim = new Customer("Jim", "Jim@gmail.com");
        System.out.println("Customer name: " + Jim.getName() + " credit limit: " + Jim.getCreditLimit()
                + " email: " + Jim.getEmail());



    }
}
