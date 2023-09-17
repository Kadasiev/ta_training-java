package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.task_carousel;

public class TaskCarousel {
    private final Task[] tasks;
    private int i = 0;

    public TaskCarousel(int capacity) {
        tasks = new Task[Math.max(capacity, 0)];
    }

    public boolean addTask(Task task) {
        if(task != null && !isFull() && !task.isFinished()){
            for(int i = 0; i < tasks.length; i++) {
                if (tasks[i] == null) {
                    tasks[i] = task;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean execute() {
        while(!isEmpty()){
            if(i == tasks.length){
                i = 0;
            }
            if(tasks[i] != null) {
                tasks[i].execute();

                if(tasks[i].isFinished()){
                    tasks[i] = null;
                }
                i++;
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean isFull() {
        for (Task task : tasks) {
            if (task == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for(Task task : tasks){
            if(task != null && !task.isFinished()){
                return false;
            }
        }
        return true;
    }
}

