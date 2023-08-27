package dev.lpa;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        //return true if contact doesn't exist
        //return false if does exist
        if (findContact(contact) == -1){
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        //return true if contact exists and was updated
        //false if contact doesn't exists
        if(findContact(oldContact) != -1){
            myContacts.set(findContact(oldContact), newContact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        //return true if contact exists and was removed
        //false if contact doesn't exist
        if(findContact(contact) != -1){
            myContacts.remove(findContact(contact));
            return true;
        }
        return false;

    }

    private int findContact(Contact contact){
        //return value of its position in arraylist -1 if doesn't exist

        for (int i = 0; i < myContacts.size(); i++){
            if(contact.getName().contains(myContacts.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    private int findContact(String contact){
        //return value of its position in arraylist -1 if doesn't exist
        for (int i = 0; i < myContacts.size(); i++){
            if(contact.contains(myContacts.get(i).getName())){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName){
        //use String to search for the name and return contact, null if
        //doesn't exist
        if(findContact(contactName) == -1){
            return null;
        }
        return myContacts.get(findContact(contactName));
    }

    public void printContacts(){

        System.out.println("Contact list:");
        for (int i = 0; i < myContacts.size(); i++){
            int position = i + 1;
            String name = myContacts.get(i).getName();
            String number = myContacts.get(i).getPhoneNumber();

            System.out.println(position + ". " + name + " -> " + number);
        }

    }
}
