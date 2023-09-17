package com.epam.training.student_david_kadasiev.introduction_to_oop.sprint_planning;

import com.epam.training.student_david_kadasiev.introduction_to_oop.sprint_planning.tickets.Bug;
import com.epam.training.student_david_kadasiev.introduction_to_oop.sprint_planning.tickets.Ticket;
import com.epam.training.student_david_kadasiev.introduction_to_oop.sprint_planning.tickets.UserStory;
import java.util.Arrays;

public class Sprint {
    private final int capacity;
    private final int ticketLimit;
    private final Ticket[] tickets;
    private int index = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory == null)
            return false;

        if(userStory.isCompleted())
            return false;

        if(getTotalEstimate() + userStory.getEstimate() > capacity)
            return false;

        if(index >= ticketLimit)
            return false;

        UserStory[] dependencies = userStory.getDependencies();
        boolean isFound = false;

        for(UserStory dependency: dependencies){
            for(int i = 0; i < index; i++){
                if(dependency == tickets[i])
                    isFound = true;
            }
            if(isFound){
                isFound = false;
            }else{
                return false;
            }
        }
        tickets[index++] = userStory;
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null)
            return false;

        if(bugReport.isCompleted())
            return false;

        if(getTotalEstimate() + bugReport.getEstimate() > capacity)
            return false;

        if(index < ticketLimit){
            tickets[index++] = bugReport;
            return true;
        }else{
            return false;
        }
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, index);
    }

    public int getTotalEstimate() {
        int totalEstimate = 0;

        for(Ticket ticket: tickets){
            if(ticket != null)
                totalEstimate += ticket.getEstimate();
        }
        return totalEstimate;
    }
}
