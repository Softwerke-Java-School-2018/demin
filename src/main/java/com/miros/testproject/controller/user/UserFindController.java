package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for find User elements
 */
public class UserFindController extends BaseController {
    private UserService userService = BaseClassService.getInstance().getUserService();
    private SortClass sortClass = SortClass.getInstance();
    private List<User> userList;

    /**
     * @param id
     */
    public void findId(Integer id) {
        utils.printLine(userService.find(id));
        waitForEnter();
    }

    /**
     * @param name
     */
    public void findName(String name) {
        userList = userService
                .findAll()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        userList
                .forEach(utils::printLine);
        sortClass.sortFunc(UserFindController.class, userList);
    }

    /**
     * @param birthDay
     */
    public void findBirthDay(String birthDay) {
        localDate = LocalDate.parse(birthDay, formatter);
        userList = userService
                .findAll()
                .filter(s -> s.getBirthDay().equals(localDate))
                .collect(Collectors.toList());
        userList
                .forEach(utils::printLine);
        sortClass.sortFunc(UserFindController.class, userList);
    }

    public void showAll() {
        userList = userService
                .findAll()
                .collect(Collectors.toList());
        userList
                .forEach(utils::printLine);
        sortClass.sortFunc(UserFindController.class, userList);
    }
}
