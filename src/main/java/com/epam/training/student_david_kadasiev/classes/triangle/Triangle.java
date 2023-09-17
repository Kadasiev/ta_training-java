package com.epam.training.student_david_kadasiev.classes.triangle;

import static java.lang.Math.sqrt;
import com.epam.training.student_david_kadasiev.classes.segments.Segment;
import com.epam.training.student_david_kadasiev.classes.segments.Point;



class Triangle {
    final private Point a;
    final private Point b;
    final private Point c;
    final private double ab;
    final private double bc;
    final private double ac;

    public Triangle(Point a, Point b, Point c) {
        ab = new Segment(a, b).length();
        bc = new Segment(b, c).length();
        ac = new Segment(a, c).length();

        if((ab + ac <= bc || ab + bc <= ac || ac + bc <= ab) || isDegenerative(a, b, c))
            throw new IllegalArgumentException();

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double s = (ab + bc + ac) / 2;
        return sqrt(s * (s - ab) * (s - bc) * (s - ac));
    }

    public Point centroid(){
        Point x1 = new Segment(a, b).middle();
        Point y1 = c;
        Point x2 = a;
        Point y2 = new Segment(b, c).middle();

        Segment one = new Segment(x1, y1);
        Segment two = new Segment(x2, y2);

        return one.intersection(two);
    }

    private boolean isDegenerative(Point one, Point two, Point three){
        double result = one.getX() * two.getY() + two.getX() * three.getY() + three.getX() * one.getY() - one.getX() * three.getY() - two.getX() * one.getY() - three.getX() * two.getY();
        return result == 0;
    }

}
