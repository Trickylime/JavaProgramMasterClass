package dev.lpa;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {



    public static void main(String[] args) {

        LinkedList<Place> placeList = new LinkedList<>();

        addPlace(placeList, new Place("Adelaide", 1374));
        addPlace(placeList, new Place("Alice Springs", 2771));
        addPlace(placeList, new Place("Brisbane", 917));
        addPlace(placeList, new Place("Darwin", 3972));
        addPlace(placeList, new Place("Melbourne", 877));
        addPlace(placeList, new Place("Perth", 3923));
        addPlace(placeList, new Place("Sydney", 0));
        addPlace(placeList, new Place("Adelaide", 1374));

        System.out.println(placeList);
        scannerStuff(placeList);

    }

    public static void addPlace(LinkedList<Place> list, Place place){

        for (Place value : list) {
            if (value.getPlace().contains(place.getPlace())) {
                System.out.println("Found duplicate: " + place);
                return;
            }
        }

        list.add(place);

        for(int i = 0; i < list.size(); i++){
            if(place.getDistance() < list.get(i).getDistance()){
                list.add(i, place);
                list.removeLast();
                break;
            }
        }
    }

    public static void scannerStuff(LinkedList<Place> list){

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int i = 0;

        while(flag){
            String textBlock = """
                Available Actions (Select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""";
            System.out.println("-".repeat(10));
            System.out.print(textBlock);

            String input = scanner.nextLine().toUpperCase();
            input = String.valueOf(input.charAt(0));

            switch(input){
                case "F" -> {
                    System.out.println("Your current position is: " + list.get(i));
                    i++;
                    System.out.println("Your new position is: " + list.get(i));
                }
                case "B" -> {
                    System.out.println("Your current position is: " + list.get(i));
                    i--;
                    System.out.println("Your new position is: " + list.get(i));
                }
                case "L" -> System.out.println(list);
                case "M" -> { continue; }
                case "Q" -> {
                    System.out.println("You have quit, goodbye.");
                    flag = false;
                }
                default -> System.out.println("Invalid Input");
            }

        }
    }


}
