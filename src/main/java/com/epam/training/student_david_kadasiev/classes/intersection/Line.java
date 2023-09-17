package com.epam.training.student_david_kadasiev.classes.intersection;

public class Line {
    private final int k;
    private final int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if(this.k == other.k && this.b != other.b)
            return null;

        if(this.k == other.k)
            return null;

        int x = (-(this.b) + other.b) / (this.k - other.k);
        int y = this.k * x + this.b;

        return new Point(x, y);
    }
}
