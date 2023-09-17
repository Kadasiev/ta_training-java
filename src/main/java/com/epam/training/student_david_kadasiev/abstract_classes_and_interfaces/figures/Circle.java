package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures;

import com.epam.training.student_david_kadasiev.classes.segments.Point;

class Circle extends Figure {
    private final Point a;
    private final double radius;

    Circle(Point a, double radius){
        this.a = a;
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String pointsToString(){
        return a.toString();
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + "[" + a.toString() + radius + "]";
    }

    @Override
    public Point leftmostPoint(){
        return new Point(a.getX() - radius, a.getY());
    }
}
