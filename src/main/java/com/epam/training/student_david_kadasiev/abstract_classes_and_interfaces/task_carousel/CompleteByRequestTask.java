package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.task_carousel;

public class CompleteByRequestTask implements Task {
    private boolean isComplete;
    private boolean isFinished;

    @Override
    public void execute() {
        isFinished = isComplete;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        isComplete = true;
    }
}
