package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


public class UserFindController extends BaseClassController {
    private UserService userService = new UserService();
    private List<User> tempUserDAO = tempDataService.getTempDAOUserList();
    private List<User> userList;

    /**
     *
     * @param id
     */
    public void findId(Integer id) {
        utils.printLine(userService.find(id));
        waitForEnter();
    }

    /**
     *
     * @param name
     */
    public void findName(String name) {
        userList = userService
                .findAll()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        userList
                .forEach(utils::printLine);
        tempUserDAO.clear();
        tempUserDAO.addAll(userList);
        utils.sortFunc(userFindController);
    }

    /**
     *
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
        tempUserDAO.clear();
        tempUserDAO.addAll(userList);
        utils.sortFunc(userFindController);
    }

    public void showAll() {
        userList = userService
                .findAll()
                .collect(Collectors.toList());
        userList
                .forEach(utils::printLine);
        tempUserDAO.clear();
        tempUserDAO.addAll(userList);
        utils.sortFunc(userFindController);
    }
}
