package com.epam.training.student_david_kadasiev.conditions_and_loops.meet_strangers;

import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amountOfStrangers = scan.nextInt();
        scan.nextLine();

        if (amountOfStrangers > 0) {
            String[] names = new String[amountOfStrangers];
            for(int i = 0; i < amountOfStrangers; i++){
                names[i] = scan.nextLine();
            }
            for(String name : names){
                System.out.println("Hello, " + name);
            }
        } else if (amountOfStrangers == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            System.out.println("Seriously? Why so negative?");
        }
    }
}
