package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures_extra;

import com.epam.training.student_david_kadasiev.classes.segments.Point;

abstract class Figure{
    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
}
