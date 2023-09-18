package com.epam.training.student_david_kadasiev.conditions_and_loops.meet_an_agent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int passwordFromUser = scan.nextInt();

        if(passwordFromUser == PASSWORD){
            System.out.println("Hello, Agent");
        }
        else{
            System.out.println("Access denied");
        }
    }
}
