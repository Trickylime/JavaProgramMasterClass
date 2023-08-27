public class TeenNumberChecker {
    public static boolean hasTeen(int tCheck1, int tCheck2, int tCheck3){
        return tCheck1 >= 13 && tCheck1 <= 19 ||
                tCheck2 >= 13 && tCheck2 <= 19 ||
                tCheck3 >= 13 && tCheck3 <= 19;
    }

    public static boolean isTeen(int isTeen){
        return isTeen >= 13 && isTeen <= 19;
    }
}
