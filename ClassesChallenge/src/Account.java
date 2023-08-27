public class Account {
    private String accountNumber;
    private double accountBalance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account(){
        this("56789", 2.50, "Default name", "default address",
                "Default phone");
        System.out.println("Empty constructor called");
    }

    public Account(String accountNumber, double accountBalance, String customerName, String email,
                   String phone){
        System.out.println("Account constructor with parameters called");
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.email = email;
        phoneNumber = phone;
    }

    public Account(String customerName, String email, String phoneNumber) {
        this("99999", 100.55, customerName, email, phoneNumber);
//        this.customerName = customerName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
    }

    public void deposit(double deposit){
        System.out.println("Your balance is: " + accountBalance);
        System.out.println("You have deposited:  " + deposit + " in to your account");
        accountBalance += deposit;
        System.out.println("Your new balance is " + accountBalance);

    }

    public void withdraw(double withdraw){
        System.out.println("Your balance is: " + accountBalance);
        System.out.println("You have withdrawn: " + withdraw + " from your account");
        accountBalance -= withdraw;
        System.out.println("Your new balance is " + accountBalance);
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
