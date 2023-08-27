package dev.lpa;

public class Main {

    public static void main(String[] args) {

        MobilePhone myPhone = new MobilePhone("999");
        Contact jack = new Contact("Jack", "001");
        Contact church = new Contact("Church", "002");
        Contact church2 = new Contact("Church", "102");

        System.out.println("Add jack to phone = " +
                myPhone.addNewContact(jack));

        System.out.println("Remove jack from phone = " +
                myPhone.removeContact(jack));

        System.out.println("Add jack to phone = " +
                myPhone.addNewContact(jack));

        System.out.println("Add Church to phone = " +
                myPhone.addNewContact(church));

        System.out.println("Search for Jack using string = " +
                myPhone.queryContact("Jack"));

        myPhone.printContacts();

        System.out.println("Updating church new number = " +
                myPhone.updateContact(church, church2));

        myPhone.printContacts();

    }
}
