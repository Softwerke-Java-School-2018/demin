package com.miros.testproject.util;

import com.miros.testproject.Main;
import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.controller.sort.SortViewFactory;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import com.miros.testproject.view.SortView;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);

    private void out(String message) {
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

    public boolean answer() {
        while (true) {
            out("Enter y/n for continue or stop");
            String answer = readLine();
            if ("y".equalsIgnoreCase(answer)) {
                return true;
            } else if ("n".equalsIgnoreCase(answer)) {
                return false;
            } else {
                out("Incorrect answer! Try again");
            }
        }
    }

    public void waitForEnter() {
        while (true) {
            out("Press Enter to back in Main menu");
            String str = readLine();
            if ("".equals(str)) {
                Main.getMainMenuView().baseMenu();
            } else {
                out("It's wrong, try again");
            }
        }
    }

    public void sortFunc(BaseClassController baseClassController) {
        out("Press s to make sort or press Enter to back in Main menu");
        SortViewFactory sortViewFactory = new SortViewFactory();
        SortView sortView = sortViewFactory.sortFunction(baseClassController);
        if(!sortView.equals(null)) {
            sortView.sort();
        }
    }
}


