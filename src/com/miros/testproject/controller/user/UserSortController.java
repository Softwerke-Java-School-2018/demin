package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.comparators.UserBirthDayComparator;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;

import java.util.Comparator;
import java.util.TreeSet;

public class UserSortController extends BaseController {

    private static UserSortController userSortController = new UserSortController();
    private static UserService userService = UserService.getInstance();

    public UserSortController(){}

    public static UserSortController getInstance(){
        return userSortController;
    }

    public void sortByBirthDay() {
        Comparator<User> comparator = new UserBirthDayComparator();
        TreeSet<User> users = new TreeSet<>(comparator);
        UserDAO.getInstance()
                .stream()
                .forEach(s -> users.add(s));
        for (User user : users) {
            System.out.println(user);
        }
        waitForEnter();
    }
}
