package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTask("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTask("Ann");
        sortAndPrint("Ann's Tasks", annsTasks, sortByPriority);

        Set<Task> bobsTasks = TaskData.getTask("Bob");
        Set<Task> carolsTasks = TaskData.getTask("Carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTasks, carolsTasks);

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);

        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("The True All Tasks", everyTask);

        Set<Task> missingTasks = getDifference(everyTask, tasks);
        sortAndPrint("Missing Tasks", missingTasks);

        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annsTasks, bobsTasks),
                getIntersect(carolsTasks, bobsTasks),
                getIntersect(annsTasks, carolsTasks)
        ));
        sortAndPrint("Assigned to Multiples", overlap, sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set : sets){
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task>  priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder());
        sortAndPrint("Overlapping", overlapping, priorityNatural);

    }

    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> setList){

        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> tasks : setList) {
            unionSet.addAll(tasks);
        }
        return unionSet;
    }

    private static Set<Task> getIntersect(Set<Task> set1, Set<Task> set2){

        Set<Task> interSet = new HashSet<>(set1);
        interSet.retainAll(set2);
        return interSet;
    }

    private static Set<Task> getDifference(Set<Task> set1, Set<Task> set2){

        Set<Task> diffSet = new HashSet<>(set1);
        diffSet.removeAll(set2);
        return diffSet;
    }
}
