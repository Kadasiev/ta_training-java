package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures;

import com.epam.training.student_david_kadasiev.classes.segments.Point;
import com.epam.training.student_david_kadasiev.classes.segments.Segment;

class Triangle extends Figure{
    private final Point a;
    private final Point b;
    private final Point c;

    Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area(){
        Segment ab = new Segment(a, b);
        Segment bc = new Segment(b, c);
        Segment ac = new Segment(a, c);

        double s = ( ab.length() + bc.length() + ac.length() ) / 2;

        return Math.sqrt( s * (s - ab.length()) * (s - bc.length()) * (s - ac.length()));
    }

    @Override
    public String pointsToString(){
        return a.toString() + b.toString() + c.toString();
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

        if(c.getX() < leftmost.getX()){
            leftmost = c;}

        return leftmost;
    }

}

