package com.epam.training.student_david_kadasiev.conditions_and_loops.pizza_split;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfPeople = scan.nextInt();
        int numberOfPieces = scan.nextInt();
        int numberOfPizzas = 1;

        while(((numberOfPieces * numberOfPizzas) % numberOfPeople) != 0){
            numberOfPizzas++;
        }
        System.out.println(numberOfPizzas);
    }
}
