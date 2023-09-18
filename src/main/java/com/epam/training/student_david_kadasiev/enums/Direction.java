package com.epam.training.student_david_kadasiev.enums;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;
    private static final int TOTAL_DEGREES = 360;

    public static Direction ofDegrees(int degrees) {
        degrees %= TOTAL_DEGREES;
        if(degrees < 0)
            degrees = TOTAL_DEGREES + degrees;

        switch(degrees){
            case 0:
                return Direction.N;
            case 45:
                return Direction.NE;
            case 90:
                return Direction.E;
            case 135:
                return Direction.SE;
            case 180:
                return Direction.S;
            case 225:
                return Direction.SW;
            case 270:
                return Direction.W;
            case 315:
                return Direction.NW;
            default:
                return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        degrees %= TOTAL_DEGREES;
        if(degrees < 0)
            degrees = TOTAL_DEGREES + degrees;

        if(degrees > 22 && degrees <=67){
            return Direction.NE;
        }else if(degrees > 67 && degrees <=112){
            return Direction.E;
        }else if(degrees > 112 && degrees <=157){
            return Direction.SE;
        }else if(degrees > 157 && degrees <=202){
            return Direction.S;
        }else if(degrees > 202 && degrees <=247){
            return Direction.SW;
        }else if(degrees > 247 && degrees <=292){
            return Direction.W;
        }else if(degrees > 292 && degrees <=337){
            return Direction.NW;
        }else{
            return Direction.N;
        }
    }

    public Direction opposite() {
        switch(degrees){
            case 0:
                return Direction.S;
            case 45:
                return Direction.SW;
            case 90:
                return Direction.W;
            case 135:
                return Direction.NW;
            case 180:
                return Direction.N;
            case 225:
                return Direction.NE;
            case 270:
                return Direction.E;
            case 315:
                return Direction.SE;
            default:
                return null;
        }
    }

    public int differenceDegreesTo(Direction direction) {
        int thisDir = this.ordinal();
        int inputDir = direction.ordinal();

        int i = 1;
        for(; i < 6; i++){
            if(thisDir == 8){
                thisDir = 0;
            }
            if(thisDir++ == inputDir){
                return --i * 45;
            }
        }

        i = 1;
        thisDir = this.ordinal();
        for(; i < 5; i++){
            if(thisDir == -1){
                thisDir = 7;
            }
            if(thisDir-- == inputDir){
                break;
            }
        }
        return --i * 45;
    }
}
