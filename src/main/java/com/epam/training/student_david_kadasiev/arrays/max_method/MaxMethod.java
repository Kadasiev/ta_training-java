package com.epam.training.student_david_kadasiev.arrays.max_method;

public class MaxMethod {
    public static int max(int[] values) {
        int maxValue = values[0];

        for(int value : values){
            if(value > maxValue){
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        int[] maxN = new int[]{4, 5, 48, 9, 14, 7, 11};
        System.out.println(max(maxN));
    }
}
