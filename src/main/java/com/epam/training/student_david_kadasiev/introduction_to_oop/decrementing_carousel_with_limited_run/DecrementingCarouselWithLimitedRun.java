package com.epam.training.student_david_kadasiev.introduction_to_oop.decrementing_carousel_with_limited_run;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    final private int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

    @Override
    public CarouselRun run(){
        if(isRun){
            return null;
        }else{
            isRun = true;
        }
        return new CarouselRun(elements, 2, actionLimit);
    }
}
