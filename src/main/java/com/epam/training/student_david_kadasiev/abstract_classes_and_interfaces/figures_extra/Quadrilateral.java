package com.epam.training.student_david_kadasiev.abstract_classes_and_interfaces.figures_extra;

import com.epam.training.student_david_kadasiev.classes.segments.Point;
import com.epam.training.student_david_kadasiev.classes.segments.Segment;

class Quadrilateral extends Figure {

    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d){
        if(a == null || b == null || c == null || d == null || isDegenerative(a, b, c, d))
            throw new IllegalArgumentException();

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public Point centroid(){
        Point k = new Triangle(a, b, c).centroid();
        Point f = new Triangle(b, c, d).centroid();
        Point g = new Triangle(a, c, d).centroid();
        Point h = new Triangle(a, b, d).centroid();

        return new Segment(k, g).intersection(new Segment(f, h));
    }

    @Override
    public boolean isTheSame(Figure figure){
        double epsilon = 0.01d;
        boolean vertexA = false;
        boolean vertexB = false;
        boolean vertexC = false;
        boolean vertexD = false;

        if(!(figure instanceof Quadrilateral))
            return false;

        if(Math.abs(this.a.getX() - ((Quadrilateral) figure).a.getX()) < epsilon
                && Math.abs(this.a.getY() - ((Quadrilateral) figure).a.getY()) < epsilon
                || Math.abs(this.a.getX() - ((Quadrilateral) figure).b.getX()) < epsilon
                && Math.abs(this.a.getY() - ((Quadrilateral) figure).b.getY()) < epsilon
                || Math.abs(this.a.getX() - ((Quadrilateral) figure).c.getX()) < epsilon
                && Math.abs(this.a.getY() - ((Quadrilateral) figure).c.getY()) < epsilon
                || Math.abs(this.a.getX() - ((Quadrilateral) figure).d.getX()) < epsilon
                && Math.abs(this.a.getY() - ((Quadrilateral) figure).d.getY()) < epsilon)
            vertexA = true;

        if(Math.abs(this.b.getX() - ((Quadrilateral) figure).a.getX()) < epsilon
                && Math.abs(this.b.getY() - ((Quadrilateral) figure).a.getY()) < epsilon
                || Math.abs(this.b.getX() - ((Quadrilateral) figure).b.getX()) < epsilon
                && Math.abs(this.b.getY() - ((Quadrilateral) figure).b.getY()) < epsilon
                || Math.abs(this.b.getX() - ((Quadrilateral) figure).c.getX()) < epsilon
                && Math.abs(this.b.getY() - ((Quadrilateral) figure).c.getY()) < epsilon
                || Math.abs(this.b.getX() - ((Quadrilateral) figure).d.getX()) < epsilon
                && Math.abs(this.b.getY() - ((Quadrilateral) figure).d.getY()) < epsilon)
            vertexB = true;

        if(Math.abs(this.c.getX() - ((Quadrilateral) figure).a.getX()) < epsilon
                && Math.abs(this.c.getY() - ((Quadrilateral) figure).a.getY()) < epsilon
                || Math.abs(this.c.getX() - ((Quadrilateral) figure).b.getX()) < epsilon
                && Math.abs(this.c.getY() - ((Quadrilateral) figure).b.getY()) < epsilon
                || Math.abs(this.c.getX() - ((Quadrilateral) figure).c.getX()) < epsilon
                && Math.abs(this.c.getY() - ((Quadrilateral) figure).c.getY()) < epsilon
                || Math.abs(this.c.getX() - ((Quadrilateral) figure).d.getX()) < epsilon
                && Math.abs(this.c.getY() - ((Quadrilateral) figure).d.getY()) < epsilon)
            vertexC = true;

        if(Math.abs(this.d.getX() - ((Quadrilateral) figure).a.getX()) < epsilon
                && Math.abs(this.d.getY() - ((Quadrilateral) figure).a.getY()) < epsilon
                || Math.abs(this.d.getX() - ((Quadrilateral) figure).b.getX()) < epsilon
                && Math.abs(this.d.getY() - ((Quadrilateral) figure).b.getY()) < epsilon
                || Math.abs(this.d.getX() - ((Quadrilateral) figure).c.getX()) < epsilon
                && Math.abs(this.d.getY() - ((Quadrilateral) figure).c.getY()) < epsilon
                || Math.abs(this.d.getX() - ((Quadrilateral) figure).d.getX()) < epsilon
                && Math.abs(this.d.getY() - ((Quadrilateral) figure).d.getY()) < epsilon)
            vertexD = true;

        return vertexA && vertexB && vertexC && vertexD;
    }

    private boolean isDegenerative(Point a, Point b, Point c, Point d){
        Segment ac = new Segment(a, c);
        Segment bd = new Segment(b, d);

        Point e = ac.intersection(bd);

        if(e == null)
            return true;

        return Triangle.isDegenerative(a, b, e)
                || Triangle.isDegenerative(b, e, c)
                || Triangle.isDegenerative(c, e, d)
                || Triangle.isDegenerative(a, e, d);
    }

}
