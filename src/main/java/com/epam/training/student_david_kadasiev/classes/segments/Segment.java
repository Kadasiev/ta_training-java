package com.epam.training.student_david_kadasiev.classes.segments;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

public class Segment {

    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        if(start.getX() != end.getX() || start.getY() != end.getY()){
            this.start = start;
            this.end = end;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public double length() {
        return sqrt(pow(end.getX() - start.getX(), 2) + pow(end.getY() - start.getY(), 2));
    }

    public Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    public Point intersection(Segment another) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();

        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4) ;
        // if parallel
        if(denominator == 0)
            return null;

        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4))   /   denominator;
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2))   /   denominator;
        // if not intersect
        if((t < 0 || t > 1) || (u < 0 || u > 1))
            return null;

        double x = x1 + t * (x2 - x1);
        double y = y1 + t * (y2 - y1);

        return new Point(x, y);
    }
}
