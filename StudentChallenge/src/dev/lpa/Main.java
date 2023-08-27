package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.model.Student;
import dev.lpa.model.StudentCourseComparator;
import dev.lpa.util.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int studentCount2 = 25;
        List<LPAStudent> lpaStudents2 = new ArrayList<>();
        for(int i = 0; i < studentCount2; i++){
            lpaStudents2.add(new LPAStudent());
        }

        var studentsLessThan51 =
                QueryList.getMatches(lpaStudents2, "percent", "50");

        System.out.println("Students less than 50%");
        printMoreLists(studentsLessThan51);

        System.out.println("Students sorted by ID");
        studentsLessThan51.sort(Comparator.naturalOrder());
        printMoreLists(studentsLessThan51);

        Comparator<Student> courseSorter = new StudentCourseComparator();
        System.out.println("Students sorted by Course");
        studentsLessThan51.sort(courseSorter);
        printMoreLists(studentsLessThan51);
        
    }

    public static void printMoreLists(List<? extends Student> students){

        for (var student : students){
            System.out.println(student);
        }
        System.out.println();
    }
}
