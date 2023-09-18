package com.epam.training.student_david_kadasiev.arrays.cycle_swap;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if(array.length == 0)
            return;

        int currentValue;
        int precedingValue = 0;

        for(int i = 0; i < array.length; i++){
            currentValue = array[i];
            array[i] = precedingValue;
            precedingValue = currentValue;
        }
        array[0] = precedingValue;
    }

    static void cycleSwap(int[] array, int shift) {
        if(array.length == 0)
            return;

        int currentValue;
        int precedingValue = 0;

        for(int j = 0; j < shift; j++){
            for(int i = 0; i < array.length; i++){
                currentValue = array[i];
                array[i] = precedingValue;
                precedingValue = currentValue;
            }
            array[0] = precedingValue;
        }
    }

    public static void main(String[] args) {
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 2);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array, 5);
            System.out.println(Arrays.toString(array));
        }
    }
}
