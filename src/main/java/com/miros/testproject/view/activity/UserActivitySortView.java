package com.miros.testproject.view.activity;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.activity.UserActivitySortController;
import com.miros.testproject.view.BaseView;
import com.miros.testproject.view.SortView;
import lombok.Data;
import java.util.List;


/**
 *  This class creates a menu to sort
 *  for UserActivities and redirects it to Sort controller
 */
@Data
public class UserActivitySortView extends BaseView implements SortView {
    private UserActivitySortController userActivitySortController = (UserActivitySortController) ControllersFabric.getController(UserActivitySortController.class).get();
    private final String USER_ACTIVITY_SORT_VIEW = "Choose which parameter use for sort\n" +
            "1 - User Name\n" +
            "2 - Date";

    public void sort(List userActivityStream) {
        utils.printLine(USER_ACTIVITY_SORT_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                userActivitySortController.sortUserName(userActivityStream);
            case "2":
                userActivitySortController.sortDate(userActivityStream);
            default:
                return;
        }
    }
}
