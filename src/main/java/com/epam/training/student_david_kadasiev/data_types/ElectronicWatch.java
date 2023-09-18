package com.epam.training.student_david_kadasiev.data_types;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        final int SECONDS_IN_TWENTY_FOUR_HOURS = 86400;

        int i = seconds % SECONDS_IN_TWENTY_FOUR_HOURS;

        String h = String.valueOf((i/3600));
        String m = String.format("%02d", (i%3600)/60);
        String s = String.format("%02d", (i%3600)%60);

        System.out.println(h + ":" + m + ":" + s);
    }
}
