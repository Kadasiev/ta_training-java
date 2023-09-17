package com.epam.training.student_david_kadasiev.introduction_to_oop.halving_carousel;

public class DecrementingCarousel {
    final protected int[] elements;
    protected int index = 0;
    protected boolean isRun;

    public DecrementingCarousel(int capacity) {
        elements = new int[capacity];
    }

    public boolean addElement(int element){
        if(!isRun && index < elements.length && element > 0){
            elements[index++] = element;
            return true;
        }else{
            return false;
        }
    }

    public CarouselRun run(){
        if(isRun){
            return null;
        }else{
            isRun = true;
        }
        return new CarouselRun(elements, 1);
    }
}


