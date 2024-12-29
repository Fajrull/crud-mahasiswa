package com.fajrulkhaq.utils;

import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getInt(String prompt){
        System.out.print(prompt);
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}
