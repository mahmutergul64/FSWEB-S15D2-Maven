package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name) {
        switch (name.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks);
            default:
                return new HashSet<>();
        }
    }

    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> taskSet : sets) {
            union.addAll(taskSet);
        }
        return union;
    }

    public Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> taskSet : sets) {
            union.addAll(taskSet);
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
        return intersect;
    }

    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}