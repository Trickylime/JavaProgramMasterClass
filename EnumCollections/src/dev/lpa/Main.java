package dev.lpa;

import java.util.*;

public class Main {

    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {

        List<WeekDay> annsWorkdays = new ArrayList<>(List.of(WeekDay.MONDAY,
                WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));

        EnumSet<WeekDay> annsDaySet = EnumSet.copyOf(annsWorkdays);
        System.out.println(annsDaySet.getClass().getSimpleName());
        annsDaySet.forEach(System.out::println);

        var allDaySet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(20));
        allDaySet.forEach(System.out::println);

        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaySet);
        System.out.println("-".repeat(20));
        newPersonDays.forEach(System.out::println);

        Set<WeekDay> anotherway = EnumSet.copyOf(allDaySet);
        anotherway.removeAll(annsDaySet);
        System.out.println("-".repeat(20));
        anotherway.forEach(System.out::println);

        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("-".repeat(20));
        businessDays.forEach(System.out::println);

        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);

        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});
        employeeMap.forEach(
                (k, v) -> System.out.println(k + " : " + Arrays.toString(v))
        );
    }
}
