import java.util.HashMap;

public class GameMap {
    private HashMap<String, Location> locations;
    private HashMap<String, String> nextPlaces;

    public GameMap() {
        this.locations = new HashMap<>();
        this.nextPlaces = new HashMap<>();
        initializeGameMap(); // Call a method to set up initial locations and connections
    }

    public HashMap<String, Location> getLocations() {
        return locations;
    }

    public HashMap<String, String> getNextPlaces() {
        return nextPlaces;
    }

    // Additional methods if needed

    private void initializeGameMap() {
        // Populate the locations and nextPlaces HashMaps based on your game map
        // Example:
        Location road = new Location("You are standing on a road.");
        Location forest = new Location("You are in a dense forest.");
        Location valley = new Location("You are in a valley.");
        Location wellHouse = new Location("You are near a well house.");
        Location hill = new Location("You are on a hill.");
        Location lake = new Location("You are near a lake.");
        Location stream = new Location("You are near a stream.");

        // Add locations to the locations HashMap
        locations.put("Road", road);
        locations.put("Forest", forest);
        locations.put("Valley", valley);
        locations.put("WellHouse", wellHouse);
        locations.put("Hill", hill);
        locations.put("Lake", lake);
        locations.put("Stream", stream);

        // Set up connections in the nextPlaces HashMap
        // Example:
        nextPlaces.put("You are standing on a road.",
                "A dense forest to the North (N)" + "\n"
                + "A valley to the south (S)" + "\n"
                + "A well house to the east (E)" + "\n"
                + "A hill to the west (W)");
        nextPlaces.put("You are in a dense forest.",
                "A road to the south (S)" + "\n"
                + "A lake to the east (E)");
        nextPlaces.put("You are in a valley.",
                "A road to the north (N)" + "\n"
                + "A stream to the east (E)" + "\n"
                + "A hill to the west (W)");
        nextPlaces.put("You are near a well house.",
                "A lake to the north (N)" + "\n"
                + "A stream to the south (S)" + "\n"
                + "A road to the west (W)");
        nextPlaces.put("You are on a hill.",
                "A forest to the north (N)" + "\n"
                + "A road to the east (E)");
    }
}