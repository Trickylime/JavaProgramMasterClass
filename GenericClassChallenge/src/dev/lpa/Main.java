package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mappable> mappableList = new ArrayList<>();

        Point littlehampton = new Park("Littlehampton", 50.81, -0.53);
        Point birmingham = new Park("Birmingham", 52.48, -1.89);


        double[] latitude = {34.48, 48.57, 50.80};
        double[] longitude = {32.79, 32.54, -0.54};
        Line riverArun = new River("River Arun", longitude, latitude);

        mappableList.add(littlehampton);
        mappableList.add(birmingham);
        mappableList.add(riverArun);

        System.out.println(mappableList);

        Layer<Mappable> layer = new Layer<>(mappableList);
        layer.addElement(littlehampton);
        layer.addElement(birmingham);
        layer.addElement(riverArun);
        layer.renderLayer(mappableList);

    }
}
