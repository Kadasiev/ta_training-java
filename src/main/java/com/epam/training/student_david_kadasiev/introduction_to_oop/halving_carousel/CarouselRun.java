package com.epam.training.student_david_kadasiev.introduction_to_oop.halving_carousel;

public class CarouselRun {
    final private int[] elements;
    private int currentElement = 0;
    int option;

    public CarouselRun(int[] elements, int option){
        this.elements = elements;
        this.option = option;
    }

    public int next() {
        int result;

        if(!isFinished()){
            while(true) {
                if (currentElement == elements.length){
                    currentElement = 0;
                }
                if (elements[currentElement] > 0 && option == 1) {
                    return elements[currentElement++]--;
                }
                if (elements[currentElement] > 0 && option == 2) {
                    result = elements[currentElement];
                    elements[currentElement] /= 2;
                    currentElement++;
                    return result;
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


