package com.miros.testproject;

import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;

import java.util.Scanner;

public class Utils {
    private Scanner scanner = new Scanner(System.in);
    private void out(String message){
        System.out.println(message);
    }
    public String readLine() {
        return scanner.nextLine();
    }
    public void printLine(String str) {
        out(str);
    }
    public void printLine(User user) {
        out(user.toString());
    }
    public void printLine(Device device) {
        out(device.toString());
    }
    public void printLine(UserActivity userActivity) {
        out(userActivity.toString());
    }
    public boolean answer(){
        while (true){
            out("Enter y/n for continue or stop");
            String answer = readLine();
            if("y".equalsIgnoreCase(answer)){
                return true;
            }
            else if("n".equalsIgnoreCase(answer)){
                return false;
            }
            else {
                out("Incorrect answer! Try again");
            }
        }
    }
}

