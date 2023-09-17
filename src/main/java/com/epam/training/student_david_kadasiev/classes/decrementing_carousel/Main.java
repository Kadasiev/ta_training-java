package com.epam.training.student_david_kadasiev.classes.decrementing_carousel;

public class Main {
    public static void main(String[] args){
        {
            CarouselRun run = new DecrementingCarousel(7).run();
            System.out.println(run.isFinished()); //true
            System.out.println(run.next()); //-1
        }
        {
            DecrementingCarousel carousel = new DecrementingCarousel(7);

            carousel.addElement(2);
            carousel.addElement(3);
            carousel.addElement(1);

            CarouselRun run = carousel.run();

            System.out.println(run.isFinished()); //false

            System.out.println(run.next()); //2
            System.out.println(run.next()); //3
            System.out.println(run.next()); //1

            System.out.println(run.next()); //1
            System.out.println(run.next()); //2

            System.out.println(run.next()); //1

            System.out.println(run.isFinished()); //true
            System.out.println(run.next()); //-1
        }
        {
            DecrementingCarousel carousel = new DecrementingCarousel(3);

            System.out.println(carousel.addElement(-2)); //false
            System.out.println(carousel.addElement(0)); //false

            System.out.println(carousel.addElement(2)); //true
            System.out.println(carousel.addElement(3)); //true
            System.out.println(carousel.addElement(1)); //true

            //carousel is full
            System.out.println(carousel.addElement(2)); //false

            CarouselRun run = carousel.run();

            System.out.println(run.next()); //2
            System.out.println(run.next()); //3
            System.out.println(run.next()); //1

            System.out.println(run.next()); //1
            System.out.println(run.next()); //2

            System.out.println(run.next()); //1

            System.out.println(run.isFinished()); //true
            System.out.println(run.next()); //-1
        }
        {
            DecrementingCarousel carousel = new DecrementingCarousel(10);

            System.out.println(carousel.addElement(2)); //true
            System.out.println(carousel.addElement(3)); //true
            System.out.println(carousel.addElement(1)); //true

            carousel.run();

            System.out.println(carousel.addElement(2)); //false
            System.out.println(carousel.addElement(3)); //false
            System.out.println(carousel.addElement(1)); //false
        }
        {
            DecrementingCarousel carousel = new DecrementingCarousel(10);
            System.out.println(carousel.run() == null); //false
            System.out.println(carousel.run() == null); //true
        }

    }
}
