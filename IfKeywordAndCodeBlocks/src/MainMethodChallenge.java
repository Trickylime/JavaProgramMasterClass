public class MainMethodChallenge {
    public static void main(String[] args) {

        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Jack", highScorePosition);

        highScorePosition = calculateHighScorePosition(1000);
        displayHighScorePosition("Dean", highScorePosition);

        highScorePosition = calculateHighScorePosition(500);
        displayHighScorePosition("Jamie", highScorePosition);

        highScorePosition = calculateHighScorePosition(100);
        displayHighScorePosition("Cristian", highScorePosition);

        highScorePosition = calculateHighScorePosition(50);
        displayHighScorePosition("Liam", highScorePosition);
    }

    public static void displayHighScorePosition(String playersName, int playersRank){
        if(playersRank == 1){
            System.out.println(playersName + " has managed to place " + playersRank + "st on the high score!");
        } else if (playersRank == 2){
            System.out.println(playersName + " has managed to place " + playersRank + "nd on the high score!");
        } else if (playersRank == 3) {
            System.out.println(playersName + " has managed to place " + playersRank + "rd on the high score!");
        } else {
            System.out.println(playersName + " has managed to place " + playersRank + "th on the high score!");
        }

    }

    public static int calculateHighScorePosition(int playersScore){
        if(playersScore >= 1000){
            return 1;
        } else if(playersScore >= 500){
            return 2;
        } else if(playersScore >= 100){
            return 3;
        }

        return 4;
    }
}
