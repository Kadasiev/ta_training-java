package com.epam.training.student_david_kadasiev.arrays.spiral;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] array = new int[rows][columns];
        int top = 0;
        int right = columns - 1;
        int bottom = rows - 1;
        int left = 0;
        int number = 0;

        while(true){
            for(int i = left; i <= right; i++){
                array[top][i] = ++number;
            }
            top++;
            if(top > bottom)
                break;

            for(int i = top; i <= bottom; i++){
                array[i][right] = ++number;
            }
            right--;
            if(right < left)
                break;

            for(int i = right; i >= left; i--){
                array[bottom][i] = ++number;
            }
            bottom--;
            if(bottom < top)
                break;

            for(int i = bottom; i >= top; i--){
                array[i][left] = ++number;
            }
            left++;
            if(left > right)
                break;
        }
        return array;
    }

    public static void main(String[] args) {
        {
            int[][] spiral = Spiral.spiral(3, 4);

            for (int i = 0; i < spiral.length; i++) {
                for (int j = 0; j < spiral[i].length; j++) {
                    System.out.print(String.format("%4s", spiral[i][j]));
                }
                System.out.println();
            }
        }
        {
            int[][] spiral = Spiral.spiral(4, 3);

            for (int i = 0; i < spiral.length; i++) {
                for (int j = 0; j < spiral[i].length; j++) {
                    System.out.print(String.format("%4s", spiral[i][j]));
                }
                System.out.println();
            }
        }
        {
            int[][] spiral = Spiral.spiral(5, 6);

            for (int i = 0; i < spiral.length; i++) {
                for (int j = 0; j < spiral[i].length; j++) {
                    System.out.print(String.format("%4s", spiral[i][j]));
                }
                System.out.println();
            }
        }
        {
            int[][] spiral = Spiral.spiral(5, 5);

            for (int i = 0; i < spiral.length; i++) {
                for (int j = 0; j < spiral[i].length; j++) {
                    System.out.print(String.format("%4s", spiral[i][j]));
                }
                System.out.println();
            }
        }
    }
}
