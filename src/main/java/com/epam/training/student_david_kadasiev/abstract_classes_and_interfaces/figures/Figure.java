package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures;

import com.epam.training.student_david_kadasiev.classes.segments.Point;

abstract class Figure{
    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();
}
