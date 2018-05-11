package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.controller.sort.user.UserBirthDayComparator;
import com.miros.testproject.controller.sort.user.UserNameComparator;
import com.miros.testproject.controller.sort.user.UserPatronymicComparator;
import com.miros.testproject.controller.sort.user.UserSurnameComparator;
import com.miros.testproject.data.entity.User;

import java.util.stream.Stream;

/**
 * Controller for sort User elements
 */
public class UserSortController extends BaseController {
    private SortClass sortClass = SortClass.getInstance();

    public void sortByName(Stream<User> userStream) {
        userStream = userStream.sorted(new UserNameComparator());
        userStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userStream);
    }

    public void sortBySurname(Stream<User> userStream) {
        userStream = userStream.sorted(new UserSurnameComparator());
        userStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userStream);
    }

    public void sortByPatronymic(Stream<User> userStream) {
        userStream = userStream.sorted(new UserPatronymicComparator());
        userStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userStream);
    }

    public void sortByBirthDay(Stream<User> userStream) {
        userStream = userStream.sorted(new UserBirthDayComparator());
        userStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserSortController.class, userStream);
    }
}
