package com.epam.training.student_david_kadasiev.conditions_and_loops.quadratic_equation;

import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double one = -b;
        double two = Math.pow(b, 2);
        double three = 4 * a * c;
        double four = Math.sqrt(two - three);
        double five = 2 * a;
        double six = one - four;
        double seven = six / five;

        double six2 = one + four;
        double seven2 = six2 / five;

        if(seven != seven2 && !Double.isNaN(seven2)){
            System.out.println(seven + " " + seven2);
        }else if(seven == seven2){
            System.out.println(seven);
        }else{
            System.out.println("no roots");
        }
    }
}