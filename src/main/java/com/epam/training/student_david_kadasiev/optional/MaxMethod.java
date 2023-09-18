package com.epam.training.student_david_kadasiev.optional;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        OptionalInt result = OptionalInt.empty();

        if(values != null && values.length != 0){
            int max = values[0];
            for (int value : values) {
                if (value > max) {
                    max = value;
                }
                result = OptionalInt.of(max);
            }
        }
        return result;
    }
}
