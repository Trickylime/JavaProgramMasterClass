package dev.lpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MethodAndLambdaChallenge {

    public static void main(String[] args) {

        //arraylist
        ArrayList<String> namesList = new ArrayList<>(List.of(
                "JACK", "DeAn", "cristian", "KAtY", "HaNnAH", "jamiE"
        ));

        namesList.replaceAll(String::toUpperCase);
        namesList.replaceAll(MethodAndLambdaChallenge::addRandomLetter);
        namesList.replaceAll(MethodAndLambdaChallenge::addReverseLastName);

        namesList.forEach(System.out::println);

    }

    private static String addRandomLetter(String s) {
        Random r = new Random();
        char randomLetter = (char) (r.nextInt(26) + 'A');
        return s + " " + randomLetter + ".";
    }

    private static String addReverseLastName(String s) {
        String[] name = s.split(" ");
        StringBuilder lastName = new StringBuilder(name[0]).reverse();
        return s + " " + lastName;

    }
}
