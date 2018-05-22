package com.miros.testproject.view.user;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.user.UserSortController;
import com.miros.testproject.view.BaseView;
import com.miros.testproject.view.SortView;
import lombok.Data;
import java.util.List;


/**
 *  This class creates a menu to sort
 *  for users and redirects it to Sort controller
 */
@Data
public class UserSortView extends BaseView implements SortView {
    private UserSortController userSortController = (UserSortController) ControllersFabric.getController(UserSortController.class).get();
    private final String USER_SORT_VIEW = "Choose which parameter use for sort\n" +
            "1 - Name\n" +
            "2 - Surname\n" +
            "3 - Patronymic\n" +
            "4 - BirthDay\n";


    /**
     * @param userList this contains Users to sort
     */
    public void sort(List userList) {
        utils.printLine(USER_SORT_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                userSortController.sortByName(userList);
            case "2":
                userSortController.sortBySurname(userList);
            case "3":
                userSortController.sortByPatronymic(userList);
            case "4":
                userSortController.sortByBirthDay(userList);
            default:
                return;
        }
    }
}
