package com.epam.training.student_david_kadasiev.introduction_to_oop.gradually_decreasing_carousel;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
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
