package com.epam.training.student_david_kadasiev.classes.decrementing_carousel;

public class CarouselRun {
    final private int[] elements;
    private int currentElement = 0;

    public CarouselRun(int[] elements){
        this.elements = elements;
    }

    public int next() {
        if(!isFinished()){
            while(true) {
                if (currentElement == elements.length){
                    currentElement = 0;
                }
                if (elements[currentElement] > 0){
                    return elements[currentElement++]--;

                }
                currentElement++;
            }
        }else {
            return -1;
        }
    }

    public boolean isFinished() {
        int max = 0;
        for(int el: elements){
            if(el > max){
                max = el;
            }
        }
        return max == 0;
    }
}

