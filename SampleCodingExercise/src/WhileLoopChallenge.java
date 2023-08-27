public class WhileLoopChallenge {

    public static void main(String[] args) {
        int num = 4;
        int evenNumCount = 0;
        int oddNumCount = 0;

        while(num <= 20){
            num++;
            if (isEvenNumber(num)){
                System.out.println(num + " is even");
                evenNumCount++;
                if(evenNumCount >= 5){
                    break;
                }
            } else{
                oddNumCount++;
            }

        }

        System.out.println("There were " + evenNumCount + " even numbers and " + oddNumCount + " odd numbers found.");
    }
    public static boolean isEvenNumber(int input){
        if(input % 2 == 0){
            return true;
        }
        return false;
    }
}
