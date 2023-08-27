package dev.lpa;

import java.util.Arrays;

public class Park extends Point {

    private String location;
    private double longitude;
    private double latitude;

    public Park(String location, double longitude, double latitude) {
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + location + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

class River extends Line {

    private String location;
    private double[] longitude;
    private double[] latitude;

    public River(String location, double[] longitude, double[] latitude) {
        this.location = location;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public String toString() {
        return "River{" +
                "name='" + location + '\'' +
                ", latitude=" + Arrays.toString(latitude) +
                ", longitude=" + Arrays.toString(longitude) +
                '}';
    }
}
