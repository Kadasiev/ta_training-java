package com.epam.training.student_david_kadasiev.classes.segments;

import java.text.DecimalFormat;

public class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0");
        return "(" + df.format(x) + "," + df.format(y) + ")";
    }
}
