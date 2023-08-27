package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] myArray = readIntegers();
        System.out.println(Arrays.toString(myArray));

        System.out.println(minimumValue(myArray));

    }
    public static int[] readIntegers(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert a list of numbers separated by commas");
        String input = scanner.nextLine();

        String[] splitStrings = input.split( ",");
        int[] values = new int[splitStrings.length];

        for(int i = 0; i < splitStrings.length; i++){
            values[i] = Integer.parseInt(splitStrings[i].trim());
        }

        return values;
    }

    private static int minimumValue(int[] array){
        Arrays.sort(array);
        return array[0];
    }
}




