package com.miros.controller;

import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    private static Scanner getScanner() {
        return scanner;
    }

    public static Scanner readLine(){
        System.out.println("Press Enter to back in main menu");
        return getScanner();
    }
}

