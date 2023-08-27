public class Main {

    public static void main(String[] args) {

//        Player player = new Player();
//        player.name = "Jack";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int dmg = 10;
//        player.loseHealth(dmg);
//        System.out.println("Remaining health = " + player.healthRemaining());
//
//        player.loseHealth(11);
//        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer jack = new EnhancedPlayer("Jack", 200, "Sword");
        System.out.println("Initial health is " + jack.healthRemaining());
    }
}
