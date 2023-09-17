package com.epam.training.student_david_kadasiev.classes.decrementing_carousel;

public class DecrementingCarousel {
    final private int[] elements;
    private int index = 0;
    private boolean isRun;

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
        return new CarouselRun(elements);
    }
}
