package com.epam.training.student_david_kadasiev.arrays.local_maxima_remove;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int[] maxLess = new int[0];
        int lengthOfMaxLess = 0;
        boolean isMaxima;

        for(int i = 0; i < array.length; i++){
            if(i > 0 && i < array.length - 1){
                isMaxima = array[i] > array[i - 1] && array[i] > array[i + 1];
            }else if(i == 0){
                isMaxima = array[i] > array[i + 1];
            }else {
                isMaxima = array[i] > array[i - 1];
            }
            if(!isMaxima){
                maxLess = Arrays.copyOf(maxLess, ++lengthOfMaxLess);
                maxLess[maxLess.length - 1] = array[i];
            }
        }
        return maxLess;
    }
}
