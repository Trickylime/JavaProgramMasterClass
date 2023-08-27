package dev.lpa;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public static void main(String[] args) {

        int[] myArray = getIntegers(5);
        System.out.println(Arrays.toString(myArray));

        sortIntegers(myArray);
        System.out.println(Arrays.toString(myArray));

        printArray(myArray);
    }

    public static int[] getIntegers(int arraySize){

        int[] inputArray = new int[arraySize];
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < arraySize; i++){
            System.out.println("Please input an integer: ");
            inputArray[i] = scanner.nextInt();
        }

        return inputArray;
    }

    public static void printArray(int[] intArray){
        for(int i = 0; i < intArray.length; i++){
            System.out.println("Element " + i + " contents " + intArray[i]);
        }
    }

    public static int[] sortIntegers(int[] unsortedArray){

        Arrays.sort(unsortedArray);
        int[] sortedArray = new int[unsortedArray.length];

        for (int i = 0; i < unsortedArray.length; i++) {
            sortedArray[i] = unsortedArray[(unsortedArray.length - 1) - i];
        }

        return sortedArray;
    }
}
