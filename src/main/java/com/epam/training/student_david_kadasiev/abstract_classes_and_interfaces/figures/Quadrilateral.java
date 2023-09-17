package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures;

import com.epam.training.student_david_kadasiev.classes.segments.Point;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    Quadrilateral(Point a, Point b, Point c, Point d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area(){
        Triangle one = new Triangle(a, b, c);
        Triangle two = new Triangle(a, c, d);

        return one.area() + two.area();
    }

    @Override
    public String pointsToString(){
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public Point leftmostPoint(){
        Point leftmost = a;

        if(b.getX() < leftmost.getX())
            leftmost = b;

        if(c.getX() < leftmost.getX())
            leftmost = c;

        if(d.getX() < leftmost.getX())
            leftmost = d;

        return leftmost;
    }

}

