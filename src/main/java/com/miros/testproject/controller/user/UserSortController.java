package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.comparators.UserBirthDayComparator;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;

import java.util.Comparator;
import java.util.TreeSet;

public class UserSortController extends BaseController {
    private  UserService userService = new UserService();
    public void sortByBirthDay() {
        Comparator<User> comparator = new UserBirthDayComparator();
        TreeSet<User> users = new TreeSet<>(comparator);
        userService
                .findAll()
                .forEach(s -> users.add(s));
        users
                .forEach(s->utils.printLine(s));
        waitForEnter();
    }
}
