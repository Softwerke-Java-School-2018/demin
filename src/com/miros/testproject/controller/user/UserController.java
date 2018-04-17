package com.miros.testproject.controller.user;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserController extends BaseController {

    private static UserController userController = new UserController();
    private static UserService userService = UserService.getInstance();


    public UserController() {
    }

    public static UserController getInstance() {
        return userController;
    }

    /**
     * Create new user
     *
     * @param name
     * @param surname
     * @param patronymic
     * @param birthDay
     * @return
     */
    public void create(String name, String surname, String patronymic, String birthDay) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(birthDay, formatter);

            UserDAO.getInstance().add(new User(name, surname, patronymic, localDate));
            Utils.printLine("User created");
            waitForEnter();
        } catch (DateTimeParseException e) {
            Utils.printLine("Invalid Date format, try again");
            waitForEnter();
        }
    }

    public void delete(Integer id) {
        try {
            User user = UserDAO.getInstance().get(id);
            if (UserDAO.getInstance().remove(user)) {
                Utils.printLine("User deleted");
            }
        } catch (IndexOutOfBoundsException e) {
            Utils.printLine("User with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        waitForEnter();
    }

    public void update(int id, String name, String surname, String patronymic, String birthDay) {
        try {
            User user = UserDAO.getInstance().get(id);

            if (!birthDay.equals("")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate localDate = LocalDate.parse(birthDay, formatter);
                user.setBirthDay(localDate);
            }
            if (!name.equals("")) {
                user.setName(name);
            }
            if (!surname.equals("")) {
                user.setSurname(surname);
            }
            if (!patronymic.equals("")) {
                user.setPatronymic(patronymic);
            }
        } catch (IndexOutOfBoundsException e) {
            Utils.printLine("User with " + id + " id number, doesn't exist");
            waitForEnter();
        } catch (DateTimeParseException ex) {
            Utils.printLine("Invalid Date format, try again");
            waitForEnter();
        }
        Utils.printLine("User uptated");
        waitForEnter();
    }

    public boolean exist(int id){
        return userService.exist(id);
    }
}


















