package com.miros.testproject.view.user;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.user.UserSortController;

public class UserSortView {

    private UserSortController userSortController = UserSortController.getInstance();

    private final String USER_FIND_VIEW="Choose which parameter use for sort\n" +
            "1 - Name\n" +
            "2 - Surname\n" +
            "3 - BirthDay\n";


    public void userSort(){
        Utils.printLine(USER_FIND_VIEW);
        String num = Utils.readLine();
        switch (num) {
            case "1":
                userSortController.sortByBirthDay();
        }
    }
}
