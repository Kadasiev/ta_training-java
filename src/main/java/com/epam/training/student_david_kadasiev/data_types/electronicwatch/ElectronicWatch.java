package com.epam.training.student_david_kadasiev.data_types.electronicwatch;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();

        int i = seconds % 86400;

        String h = String.valueOf((i/3600));
        String m = String.format("%02d", (i%3600)/60);
        String s = String.format("%02d", (i%3600)%60);

        System.out.println(h + ":" + m + ":" + s);
    }
}
