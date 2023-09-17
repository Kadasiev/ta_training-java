package com.epam.training.student_david_kadasiev.conditions_and_loops.average;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int totalAmount = 0;
        int i = 0;

        while(number != 0){
            totalAmount += number;
            number = scanner.nextInt();
            i++;
        }
        System.out.println(totalAmount / i);
    }
}