package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LambdaExpressionChallenge {


    public static void main(String[] args) {
        //array
        String[] namesArray =
                {"JACK", "DeAn", "cristian", "KAtY", "HaNnAH", "jamiE"};
        Arrays.setAll(namesArray, i -> namesArray[i].toUpperCase());
//        System.out.println(Arrays.toString(namesArray));


        //arraylist
        ArrayList<String> names = new ArrayList<>(List.of(
                "JACK", "DeAn", "cristian", "KAtY", "HaNnAH", "jamiE"
        ));
        names.replaceAll(s -> s.toUpperCase());
        names.forEach(s -> System.out.println(s));

        //add random middle initial and include a period
        Random r = new Random();
        names.replaceAll(s -> s + " " +
                (char) (r.nextInt(26) + 'A') + ".");
        names.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(10));
        //add a last name that is a reverse of the first name
        names.replaceAll(s -> {
            String[] firstName = s.split(" ");
            s += " " + new StringBuilder(firstName[0]).reverse();
            return s;
        });
        names.forEach(s -> System.out.println(s));


        System.out.println("-".repeat(10));
        //remove names from the list if firstname doesn't match last name
        names.removeIf(s -> {
            String[] firstName = s.split(" ");
            String secondName = firstName[2];
            return !firstName[0].equals(secondName);
        });
        names.forEach(s -> System.out.println(s));

        // HOW I DID IT BEFORE I SAW I NEEDED TO USE REMOVEIF
        // Which you can see removeif is much more efficient and readable
        //        ArrayList<String> modNames = new ArrayList<>();
//        for (String name : names) {
//            String[] firstName = name.split("\\.");
//            String[] secondName = firstName[1].split(" ");
//            if (firstName[0].contains(secondName[1])) {
//                modNames.add(firstName[0] + "." + secondName[0]
//                        + " " + secondName[1]);
//            }
//        }
//        modNames.forEach(s -> System.out.println(s));
    }
}
