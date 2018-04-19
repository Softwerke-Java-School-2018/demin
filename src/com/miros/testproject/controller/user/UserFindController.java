package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;
import java.time.LocalDate;


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
}
