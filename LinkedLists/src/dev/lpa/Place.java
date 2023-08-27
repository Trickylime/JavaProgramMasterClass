package dev.lpa;

public class Place {

    private String place;
    private int distance;

    public Place(String place, int distance) {
        this.place = place;
        this.distance = distance;
    }

    public String getPlace() {
        return place;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return place + " " + distance;

    }
}
