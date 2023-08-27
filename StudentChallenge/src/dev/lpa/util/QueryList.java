package dev.lpa.util;

import dev.lpa.model.Student;

import java.util.ArrayList;
import java.util.List;

public class QueryList<S> extends ArrayList<Student> {


    public QueryList() {

    }

    public static <S extends QueryItem> List<S> getMatches
            (List<S> items, String field, String value) {

        List<S> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
