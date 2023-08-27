package dev.lpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, String hireDate) {}

public class Main {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Jack", "McGeown",
                "17/03/2023"));
        list.add(new Employee("Katy", "Salt",
                "10/01/2020"));
        list.add(new Employee("Cristian", "Rousell",
                "05/11/2015"));
        list.add(new Employee("Dean", "Goodyer",
                "09/01/2018"));
        list.add(new Employee("Liam", "Bligh",
                "28/02/2023"));

        printOrderedList(list);
    }

    public static void printOrderedList(List<Employee> list){

        int currentYear = LocalDate.now().getYear();
        class MyEmployee {

            private Employee employee;
            private String fullName;
            private int yearsWorked;

            public MyEmployee(Employee employee) {
                this.employee = employee;
                this.fullName = employee.firstName() + " " + employee.lastName();
                this.yearsWorked = currentYear - Integer.parseInt
                        (employee.hireDate().substring(6));
            }

            @Override
            public String toString() {
                return "Name: " + fullName + " Years Worked: "
                        + yearsWorked;

//                return "%s %-8d".formatted(fullName, yearsWorked);

            }
        }

        List<MyEmployee> newList = new ArrayList<>();
        for (Employee employee : list) {
            newList.add(new MyEmployee(employee));
        }

        var nameComparator = new Comparator<MyEmployee>() {

            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        };


        newList.sort(nameComparator);

        for (MyEmployee employee : newList){
            System.out.println(employee);
        }


    }
}
