package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.controller.sort.user.UserBirthDayComparator;
import com.miros.testproject.controller.sort.user.UserNameComparator;
import com.miros.testproject.controller.sort.user.UserPatronymicComparator;
import com.miros.testproject.controller.sort.user.UserSurnameComparator;
import com.miros.testproject.data.entity.User;
import java.util.List;

/**
 * Controller for sort User elements
 */
public class UserSortController extends BaseController {
    private SortClass sortClass = SortClass.getInstance();

    public void sortByName(List<User> userList) {
        userList.stream()
                .sorted(new UserNameComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userList);
    }

    public void sortBySurname(List<User> userList) {
        userList.stream()
                .sorted(new UserSurnameComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userList);
    }

    public void sortByPatronymic(List<User> userList) {
        userList.stream()
                .sorted(new UserPatronymicComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userList);
    }

    public void sortByBirthDay(List<User> userList) {
        userList.stream()
                .sorted(new UserBirthDayComparator())
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userList);
    }
}
