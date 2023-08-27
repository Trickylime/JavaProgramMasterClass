package dev.lpa;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction){

        if (findCustomer(customerName) != null) return false;
        //create new customer
        Customer newCustomer = new Customer(customerName, initialTransaction);
        customers.add(newCustomer);
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double transaction){

        Customer customer = findCustomer(customerName);
        if (customer == null) return false;

        customer.addTransaction(transaction);
        return true;
    }

    private Customer findCustomer(String customerName){

        for (Customer customer : customers) {
            if (customer.getName().contains(customerName)) {
                return customer;
            }
        }
        return null;
    }
}
