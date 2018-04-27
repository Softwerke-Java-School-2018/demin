package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.comparators.UserBirthDayComparator;
import com.miros.testproject.controller.comparators.UserNameComparator;
import com.miros.testproject.controller.comparators.UserSurnameComparator;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

public class UserSortController extends BaseController {

    private  UserService userService = new UserService();

    public void sortByBirthDay() {

        List<User> userList;

        userList = userService
                .findAll()
                .collect(Collectors.toList());

        userService
                .findAll();
        waitForEnter();
    }
}
