package com.epam.training.student_david_kadasiev.conditions_and_loops.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int dayForward = scan.nextInt();
        int nightBackward = scan.nextInt();
        int heightOfTree = scan.nextInt();
        int amountOfPassedFeets = 0;
        int amountOfDays = 0;

        if(dayForward - nightBackward > 0 || dayForward >= heightOfTree){
            while(amountOfPassedFeets < heightOfTree){
                amountOfPassedFeets += dayForward;
                amountOfDays++;
                if(amountOfPassedFeets >= heightOfTree){
                    break;
                }else{
                    amountOfPassedFeets -= nightBackward;
                }
            }
            System.out.println(amountOfDays);
        }else{
            System.out.println("Impossible");
        }
    }
}
