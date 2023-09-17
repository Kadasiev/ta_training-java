package com.epam.training.student_david_kadasiev.introduction_to_oop.halving_carousel;

public class HalvingCarousel extends DecrementingCarousel {
    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    @Override
    public CarouselRun run(){
        if(isRun){
            return null;
        }else{
            isRun = true;
        }
        return new CarouselRun(elements, 2);
    }
}
