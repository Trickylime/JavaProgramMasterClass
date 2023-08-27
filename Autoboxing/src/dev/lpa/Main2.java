package dev.lpa;

public class Main2 {

    public static void main(String[] args) {

        Bank myBank = new Bank("myBank");

        Customer jack = new Customer("Jack");

        myBank.addCustomer(jack);
        myBank.addTransaction(jack, 100.0);

        System.out.println(jack);
    }
}
