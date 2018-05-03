package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.controller.comparators.user.UserBirthDayComparator;
import com.miros.testproject.controller.comparators.user.UserNameComparator;
import com.miros.testproject.controller.comparators.user.UserPatronymicComparator;
import com.miros.testproject.controller.comparators.user.UserSurnameComparator;
import com.miros.testproject.data.entity.User;

import java.util.*;

public class UserSortController extends BaseClassController {
    private List<User> tempUserDAO = tempDataService.getTempDAOUserList();

    public void sortByName() {
        comparator = new UserNameComparator();
        Collections.sort(tempUserDAO, comparator);
        tempUserDAO
                .forEach(utils::printLine);
        utils.sortFunc(userFindController);
    }

    public void sortBySurname() {
        comparator = new UserSurnameComparator();
        Collections.sort(tempUserDAO, comparator);
        tempUserDAO
                .forEach(s -> utils.printLine(s));
        utils.sortFunc(userFindController);
    }

    public void sortByPatronymic() {
        comparator = new UserPatronymicComparator();
        Collections.sort(tempUserDAO, comparator);
        tempUserDAO
                .forEach(s -> utils.printLine(s));
        utils.sortFunc(userFindController);
    }

    public void sortByBirthDay() {
        comparator = new UserBirthDayComparator();
        Collections.sort(tempUserDAO, comparator);
        tempUserDAO
                .forEach(s -> utils.printLine(s));
        utils.sortFunc(userFindController);
    }
}
