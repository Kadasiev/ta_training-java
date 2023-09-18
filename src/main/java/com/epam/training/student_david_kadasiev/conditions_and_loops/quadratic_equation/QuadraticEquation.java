package com.epam.training.student_david_kadasiev.conditions_and_loops.quadratic_equation;

import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double additionResult = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a);
        double subtractionResult = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2*a);

        if(subtractionResult != additionResult && !Double.isNaN(additionResult)){
            System.out.println(subtractionResult + " " + additionResult);
        }else if(subtractionResult == additionResult){
            System.out.println(subtractionResult);
        }else{
            System.out.println("no roots");
        }
    }
}