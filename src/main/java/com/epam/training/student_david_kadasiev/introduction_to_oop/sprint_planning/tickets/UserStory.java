package com.epam.training.student_david_kadasiev.introduction_to_oop.sprint_planning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    final private UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
        for(UserStory story: dependsOn){
            if(!story.isCompleted())
                return;
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        return Arrays.copyOf(dependsOn, dependsOn.length);
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
