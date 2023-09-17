package com.epam.training.student_david_kadasiev.arrays.sum_of_previous;

import java.util.Arrays;

public class SumOfPrevious {
    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){
        boolean[] isSum = new boolean[array.length];

        for(int i = 2; i < isSum.length; i++){
            isSum[i] = array[i - 2] + array[i - 1] == array[i];
        }
        return isSum;
    }
}
