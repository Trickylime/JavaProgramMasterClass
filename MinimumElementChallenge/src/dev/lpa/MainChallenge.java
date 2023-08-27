package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class MainChallenge {

    public static void main(String[] args) {

        int myInt = readInteger();
        System.out.println("myInt = " + myInt);

        int[] myArray = readElements(myInt);
        System.out.println("myArray = " + Arrays.toString(myArray));

        System.out.println(findMin(myArray));


    }
    public static int readInteger(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert size of array:");
        String arraySizeString = scanner.nextLine();
        int arraySizeInt = Integer.parseInt(arraySizeString);

        return arraySizeInt;
    }

    private static int[] readElements(int arraySize){

        int[] inputArray = new int[arraySize];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < inputArray.length; i++){
            System.out.println("input number for array:");
            inputArray[i] = scanner.nextInt();
        }

        return inputArray;
    }

    private static int findMin(int[] array){
        Arrays.sort(array);
        return array[0];
    }
}




