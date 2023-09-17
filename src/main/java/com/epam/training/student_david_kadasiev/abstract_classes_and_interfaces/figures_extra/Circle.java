package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures_extra;

import com.epam.training.student_david_kadasiev.classes.segments.Point;

class Circle extends Figure{

    private final Point a;
    private final double radius;

    public Circle(Point a, double radius){
        if(radius <= 0 || a == null)
            throw new IllegalArgumentException();

        this.a = a;
        this.radius = radius;
    }

    @Override
    public Point centroid(){
        return a;
    }

    @Override
    public boolean isTheSame(Figure figure){
        double epsilon = 0.01d;

        return figure instanceof Circle
                && Math.abs(this.a.getX() - ((Circle) figure).a.getX()) < epsilon
                && Math.abs(this.a.getY() - ((Circle) figure).a.getY()) < epsilon
                && Math.abs(this.radius - ((Circle) figure).radius) < epsilon;
    }
}
