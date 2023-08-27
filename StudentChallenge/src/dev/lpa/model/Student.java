package dev.lpa.model;

import dev.lpa.util.QueryItem;

import java.util.Random;

public class Student implements Comparable<Student>, QueryItem {

    private String name;
    private String course;
    private int yearStarted;

    private static int LAST_ID = 1000;
    protected int id;

    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public Student() {
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
        id = LAST_ID + random.nextInt(0, 1000);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %-15d %d".formatted(name, course, yearStarted, id);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
//        return name.compareTo(o.name);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }
}
