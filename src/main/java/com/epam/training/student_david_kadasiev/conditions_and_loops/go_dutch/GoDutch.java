package com.epam.training.student_david_kadasiev.conditions_and_loops.go_dutch;

import java.util.Scanner;

public class GoDutch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bill = scan.nextInt();
        int amountOfFriends = scan.nextInt();

        if (bill > 0 && amountOfFriends > 0) {
            bill += (bill / 100 * 10);
            System.out.println(bill / amountOfFriends);
        }else if(bill < 0 || amountOfFriends <= 0) {
            if (bill < 0) {
                System.out.println("Bill total amount cannot be negative");
            }
            if (amountOfFriends <= 0) {
                System.out.println("Number of friends cannot be negative or zero");
            }
        }else {
            System.out.println(0);
        }
    }
}
