package com.epam.training.student_david_kadasiev.introduction_to_oop.decrementing_carousel_with_limited_run;

public class CarouselRun {

    final private int[] elements;
    private int currentElement = 0;
    int runType;
    int runLimit = -1;
    int amountOfRun = 0;

    public CarouselRun(int[] elements, int runType){
        this.elements = elements;
        this.runType = runType;
    }

    public CarouselRun(int[] elements, int runType, int runLimit){
        this.elements = elements;
        this.runType = runType;
        this.runLimit = runLimit;
    }


    public int next() {
        if(!isFinished()){
            if(runType == 2){
                amountOfRun++;
            }
            while(true) {
                if (currentElement == elements.length){
                    currentElement = 0;
                }
                if (elements[currentElement] > 0) {
                    return elements[currentElement++]--;
                }
                currentElement++;
            }
        }else {
            return -1;
        }
    }

    public boolean isFinished() {
        if(runType == 2 && amountOfRun >= runLimit)
            return true;

        int max = 0;
        for(int element: elements){
            if(element > max){
                max = element;
            }
        }
        return max == 0;
    }
}



