package com.miros.testproject.view.user;

import com.miros.testproject.controller.user.UserSortController;
import com.miros.testproject.view.BaseClassView;
import lombok.Data;

@Data
public class UserSortView extends BaseClassView {
    private UserSortController userSortController = new UserSortController();
    private final String USER_SORT_VIEW = "Choose which parameter use for sort\n" +
            "1 - Name\n" +
            "2 - Surname\n" +
            "3 - Patronymic\n" +
            "4 - BirthDay\n";

    public void userSort() {
        utils.printLine(USER_SORT_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                userSortController.sortByName();
            case "2":
                userSortController.sortBySurname();
            case "3":
                userSortController.sortByPatronymic();
            case "4":
                userSortController.sortByBirthDay();
            default:
                utils.printLine("It's Wrong");
                waitForEnter();
        }
    }
}
