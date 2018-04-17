package com.miros.testproject;

import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;

import java.util.Scanner;

public class Utils {

    private static Scanner scanner = new Scanner(System.in);

    public Scanner scanner() {
        return scanner;
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static void printLine(String str) {
        System.out.println(str);
    }

    public static void printLine(User user) {
        System.out.println(user);
    }

    public static void printLine(Device device) {
        System.out.println(device);
    }

    public static void printLine(UserActivity userActivity) {
        System.out.println(userActivity);
    }

    public static boolean answer(){
        while (true){
            System.out.println("Enter y/n for continue or stop");
            String answer = readLine();
            if(answer.equalsIgnoreCase("y")){
                return true;
            }
            else if(answer.equalsIgnoreCase("n")){
                return false;
            }
            else {
                System.out.println("Incorrect answer! Try again");
            }
        }
    }
}

