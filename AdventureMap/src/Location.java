import java.util.HashMap;

public class Location {
    private String description;
    private HashMap<String, String> nextPlaces;

    public Location(String description) {
        this.description = description;
        this.nextPlaces = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, String> getNextPlaces() {
        return nextPlaces;
    }

    // Additional methods if needed
}
