import java.util.HashMap;

public class Location {
    private String description;
    private HashMap<String, String> nextLocations;

    public Location(String description) {
        this.description = description;
        this.nextLocations = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, String> getNextLocations() {
        return nextLocations;
    }

    public void addNextLocation(String direction, String location) {
        nextLocations.put(direction.toUpperCase(), location);
    }
}
