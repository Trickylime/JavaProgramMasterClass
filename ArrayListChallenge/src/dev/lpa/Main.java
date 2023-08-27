package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> shoppingList = new ArrayList<>();

        while(true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Available actions:");
            System.out.println("0 to shutdown");
            System.out.println("1 - to add item(s) to list (comma delimited list)");
            System.out.println("2 - to remove any items (comma delimited list)");

            String input = scanner.nextLine();

            System.out.println("-".repeat(10));

            if(input.contains("0")){
                System.out.println("Your final list is: ");
                System.out.println(shoppingList);

                System.out.println("Closing Program, kthxbai");
                System.out.println("-".repeat(10));

                scanner.close();
                break;
            }
            if(input.contains("1")){
                System.out.println("Add items: ");
                String listInput = scanner.nextLine();

                String[] splitList = listInput.split(","); //split the words
                for(int i = 0; i < splitList.length; i++){
                    //add a check if something is already in list then don't add
                    //and print statement.
                    shoppingList.add(splitList[i].trim());
                }
//                Collections.addAll(shoppingList, splitList);
                shoppingList.sort(Comparator.naturalOrder()); //sort list

                System.out.println("-".repeat(10));
                System.out.println(shoppingList); // print list
                System.out.println("-".repeat(10));

            }
            if(input.contains("2")){
                System.out.println("current items: " + shoppingList);
                System.out.println("Remove items: ");
                String listInput = scanner.nextLine();
                String[] splitList = listInput.split(","); //split the words
                for (String s : splitList) {
                    shoppingList.remove(s.trim());
                }

                shoppingList.sort(Comparator.naturalOrder()); //sort list

                System.out.println("-".repeat(10));
                System.out.println("Your new current list:");
                System.out.println(shoppingList);
                System.out.println("-".repeat(10));
                //to remove any items (comma delimited list)
            }
        }

    }
}
