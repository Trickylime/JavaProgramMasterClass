package dev.lpa;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTransactions(Double newTransaction) {
        this.transactions.add(newTransaction);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    // customer transaction can be a credit which means
    // a positive amount or a debit, a negative amount
}
