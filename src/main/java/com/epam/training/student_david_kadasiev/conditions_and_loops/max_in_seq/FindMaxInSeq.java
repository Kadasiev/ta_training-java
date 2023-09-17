package com.epam.training.student_david_kadasiev.conditions_and_loops.max_in_seq;

import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scan = new Scanner(System.in);
        int maxValue = scan.nextInt();
        int nextValue = scan.nextInt();

        while(nextValue != 0){
            if(nextValue > maxValue){
                maxValue = nextValue;
            }
            nextValue = scan.nextInt();
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        // Get a result of your code
        System.out.println(max());
    }
}
