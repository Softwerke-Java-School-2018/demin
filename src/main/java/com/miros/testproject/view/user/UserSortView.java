package com.miros.testproject.view.user;

import com.miros.testproject.controller.user.UserSortController;
import com.miros.testproject.view.BaseView;

public class UserSortView extends BaseView {
    private UserSortController userSortController = new UserSortController();
    private final String USER_FIND_VIEW="Choose which parameter use for sort\n" +
            "1 - Name\n" +
            "2 - Surname\n" +
            "3 - BirthDay\n";

    public void userSort(){
        utils.printLine(USER_FIND_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                userSortController.sortByBirthDay();
        }
    }
}
