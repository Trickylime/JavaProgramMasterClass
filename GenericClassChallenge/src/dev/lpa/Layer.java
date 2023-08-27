package dev.lpa;

import java.util.List;

public class Layer<T extends Mappable> {

    private List<T> elements;

    public Layer(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T t){

        if(!elements.contains(t)){
            elements.add(t);
        }
    }

    public void renderLayer(List<T> list){

        for (T t : list) {
            t.render();
        }
    }
}
