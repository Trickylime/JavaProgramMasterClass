import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] myArray = {1, 5, 6, 7, 9};
        System.out.println(Arrays.toString(myArray));

        myArray = reverse(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    private static int[] reverse(int[] unsortedArray){

        int[] sortedArray = new int[unsortedArray.length];
        for(int i = 0; i < unsortedArray.length; i++){
            sortedArray[i] = unsortedArray[(unsortedArray.length - 1) - i];
        }

        return sortedArray;
    }

    private static void reverse2(int[] inputArray){
        int temp;
        int arrayLength = inputArray.length - 1;
        int halfArrayLength = arrayLength / 2;

        System.out.println("Array = " + Arrays.toString(inputArray));

        for (int i = 0; i < halfArrayLength; i++){
            temp = inputArray[i];
            inputArray[i] = inputArray[arrayLength - i];
            inputArray[arrayLength - i] = temp;
        }

        System.out.println("Reversed array = " + Arrays.toString(inputArray));
    }
}
