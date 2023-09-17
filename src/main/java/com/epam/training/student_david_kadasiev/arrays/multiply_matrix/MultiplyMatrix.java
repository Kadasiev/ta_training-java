package com.epam.training.student_david_kadasiev.arrays.multiply_matrix;

import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int matrix1Rows = matrix1.length;
        int matrix1Columns = matrix1[0].length;
        int matrix2Columns = matrix2[0].length;
        int[][] multipliedMatrix = new int[matrix1Rows][matrix2Columns];

        for(int i = 0; i < matrix1Rows; i++){
            for(int j = 0; j < matrix2Columns; j++){
                for(int k = 0; k < matrix1Columns; k++){
                    multipliedMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return multipliedMatrix;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
