package dev.lpa;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private boolean findCustomer(Customer newCustomer){

        for (int i = 0; i < customers.size(); i++){
            if(newCustomer.getName().contains(customers.get(i).getName())){
                System.out.println("Customer found");
                return true;
            }
        }
        return false;
    }

    public boolean addCustomer(Customer newCustomer){

        if (!findCustomer(newCustomer)){
            customers.add(newCustomer);
            System.out.println(newCustomer.getName() + " has been added to the list");
            return true;
        }

        System.out.println(newCustomer.getName() + " is already on the list");
        return false;
    }

    public boolean addTransaction(Customer customer, Double transaction){

        if (!findCustomer(customer)){
            return false;
        }

        customer.addTransactions(transaction);
        printStatement(customer, transaction);
        return true;
    }

    public void printStatement(Customer customer, Double transaction){

        double amount = transaction;
        System.out.println(customer.getName() + " has made a transactions of £"
        + amount);

    }
}
