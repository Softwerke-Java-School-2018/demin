package com.miros.testproject.view.activity;

import com.miros.testproject.controller.activity.UserActivitySortController;
import com.miros.testproject.view.BaseClassView;
import lombok.Data;

@Data
public class UserActivitySortView extends BaseClassView {
    private UserActivitySortController userActivitySortController = new UserActivitySortController();
    private final String USER_ACTIVITY_SORT_VIEW = "Choose which parameter use for sort\n" +
            "1 - User Name\n" +
            "2 - Date";

    public void userActivitySort() {
        utils.printLine(USER_ACTIVITY_SORT_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                userActivitySortController.sortByUserName();
            case "2":
                userActivitySortController.sortByDate();
        }
    }
}
