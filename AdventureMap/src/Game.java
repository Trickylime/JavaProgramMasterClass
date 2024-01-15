import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private GameMap gameMap;
    private Location currentPlayerLocation;
    private Scanner scanner;

    public Game() {
        this.gameMap = new GameMap();
        this.currentPlayerLocation = gameMap.getLocations().get("Road"); // Starting location
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to the Text Adventure Game!");

        while (true) { // Continue the game until the player decides to quit
            displayCurrentLocation();
            displayOptions();
            System.out.println("Select Your Compass Direction (Q to quit)");

            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("Q")) {
                System.out.println("Thanks for playing. Goodbye!");
                break; // Exit the game loop
            } else {
                movePlayer(userInput);
            }
        }

        scanner.close();
    }

    private void displayCurrentLocation() {
        System.out.println("\n" + currentPlayerLocation.getDescription());
    }

    private void displayOptions() {
        System.out.println("From here you can see:");
        HashMap<String, String> nextPlaces = gameMap.getNextPlaces();
        System.out.println(nextPlaces.get(currentPlayerLocation.getDescription()));
    }

    private void movePlayer(String direction) {
        HashMap<String, String> nextLocations = currentPlayerLocation.getNextLocations();

        if (nextLocations.containsKey(direction.toUpperCase())) {
            String newLocation = nextLocations.get(direction.toUpperCase());
            currentPlayerLocation = gameMap.getLocations().get(newLocation);
        } else {
            System.out.println("Invalid direction. Please choose a valid option.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}