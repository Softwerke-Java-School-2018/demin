package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.comparators.UserNameComparator;
import com.miros.testproject.controller.comparators.UserSurnameComparator;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserFindController extends BaseController {
    private UserService userService = new UserService();
    public User idFind(Integer id) {
        return userService.find(id);
    }
    public void findName(String name) {
        userService
                .findAll()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .forEach(e -> utils.printLine(e));
        waitForEnter();
    }
    public void findBirthDay(String birthDay) {
        localDate = LocalDate.parse(birthDay, formatter);
        userService.findAll()
                .filter(s -> s.getBirthDay().equals(localDate))
                .forEach(e->utils.printLine(e));
        waitForEnter();
    }
    public void showAll() {
        userService
                .findAll()
                .forEach(e->utils.printLine(e));
        waitForEnter();
    }
    public void nameSurnameSort(){
       List<User> userList = userService
                .findAll()
                .collect(Collectors.toList());
        Comparator comparator = new UserNameComparator()
                .thenComparing(new UserSurnameComparator());
        Collections.sort(userList, comparator);
        userList
                .forEach(s->utils.printLine(s));
        waitForEnter();
    }
}
