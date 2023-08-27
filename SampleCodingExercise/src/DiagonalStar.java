public class DiagonalStar {

    public static void main(String[] args) {
        printSquareStar(60);
    }

    public static void printSquareStar(int number) {
        if (number < 5) System.out.println("Invalid Value");
        else {
            for (int row = 0; row < number; row++) {
                for (int column = 0; column < number; column++) {
                    if (row == 0 || row == number - 1 || column == 0 || column == number - 1 || column == row || column == number - 1 - row)
                        System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.println("");
            }
        }
    }
//    public static void printSquareStar(int number){
//        if (number < 5){
//            System.out.println("Invalid Value");
//        }
//
//        int rowNumber = 0;
//        int columnNumber = 0;
//
//        for (int i = 1; i <= number; i++){
//            rowNumber = i;
//            columnNumber = 1;
//            if(columnNumber == 1){
//                System.out.print("*");
//                columnNumber++; //col2
//            }
//
//            if (rowNumber == 1 || rowNumber == number){
//                for(int e = 1; e < (number - 1); e++){
//                    System.out.print("*");
//                    columnNumber++;
//                }
//            }
//
//            //columnNumber++;
//            if(columnNumber == number){
//                System.out.print("*");
//                System.out.println(" ");
//            }
//
//        }
//    }
}
