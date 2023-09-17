package com.epam.training.student_david_kadasiev.introduction_to_oop.sprint_planning.tickets;

public class Ticket {
    private final int id;
    final private String name;
    final private int estimate;
    private boolean isCompleted;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
