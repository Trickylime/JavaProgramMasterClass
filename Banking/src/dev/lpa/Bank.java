package dev.lpa;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String branchName) {

        if (findBranch(branchName) != null) {//if branch doesn't exist, add branch
            return false;
        }

        branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName,
                               double initialTransaction) {

        Branch branch = findBranch(branchName);
        if (branch == null) return false;

        return branch.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName,
                                          double transaction) {

        Branch branch = findBranch(branchName);
        if (branch == null) return false;

        return branch.addCustomerTransaction(customerName, transaction);
    }

    private Branch findBranch(String branchName) {

        for (Branch branch : branches) {
            if (branch.getName().contains(branchName)) {
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransaction) {
        //return true if branch exists

        Branch branch = findBranch(branchName);
        if (branch == null) return false;


        System.out.println("Customer details for branch " + branch.getName());
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            System.out.println("Customer: " +
                    branch.getCustomers().get(i).getName() +
                    "[" + (i + 1) + "]");
            if (printTransaction) System.out.println("Transactions");

            if (printTransaction) {
                for (int j = 0; j < branch.getCustomers().get(i).getTransactions().size(); j++) {

                    System.out.println("[" + (j + 1) + "]  Amount " +
                            branch.getCustomers().get(i).getTransactions().get(j));
                }
            }
        }
        return true;

    }
}
