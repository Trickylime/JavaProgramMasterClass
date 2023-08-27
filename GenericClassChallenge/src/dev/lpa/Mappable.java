package dev.lpa;

import java.util.Arrays;

public interface Mappable {
    void render();

}

abstract class Point implements Mappable{

    private String location;
    private double longitude;
    private double latitude;

    @Override
    public void render() {
        System.out.println("Render " + location + " as " + getClass().getSimpleName()
        + " ([" + longitude + ", " + latitude + "])");
    }
}

abstract class Line implements Mappable{

    private String location;
    private double[] longitude;
    private double[] latitude;

    @Override
    public void render() {
        System.out.println("Render " + location + " as " + getClass().getSimpleName()
                + " ([" + Arrays.toString(longitude) + ", " + Arrays.toString(latitude) + "])");
    }
}
