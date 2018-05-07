package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.exception.ParseException;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.UserService;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Log4j2
public class UserController extends BaseClassController {
    private UserService userService = new UserService();

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
            localDate = LocalDate.parse(birthDay, formatter);
            userService.save(new User(name, surname, patronymic, localDate));
            utils.printLine("User created");
            waitForEnter();
        } catch (ParseException e) {
            utils.printLine("Invalid Date format, try again");
            log.info("User create: Invalid date format");
            waitForEnter();
        } catch (RuntimeEx e) {
            log.info("User create: Runtime exc");
        }
    }

    /**
     *
     * @param id
     */

    public void delete(int id) {
        try {
            User user = userService.find(id);
            if (userService.delete(user)) {
                utils.printLine("User deleted");
            }
        } catch (IndexOutOfBoundsException e) {
            utils.printLine("User with " + id + " id number, doesn't exist");
            waitForEnter();
        }
        waitForEnter();
    }

    /**
     *
     * @param id
     * @param name
     * @param surname
     * @param patronymic
     * @param birthDay
     */

    public void update(int id, String name, String surname, String patronymic, String birthDay) {
        try {
            User user = userService.find(id);
            if (!"".equals(birthDay)) {
                localDate = LocalDate.parse(birthDay, formatter);
                user.setBirthDay(localDate);
            }
            if (!"".equals(name)) {
                user.setName(name);
            }
            if (!"".equals(surname)) {
                user.setSurname(surname);
            }
            if (!"".equals(patronymic)) {
                user.setPatronymic(patronymic);
            }
        } catch (IndexOutOfBoundsException e) {
            utils.printLine("User with " + id + " id number, doesn't exist");
            waitForEnter();
        } catch (DateTimeParseException ex) {
            utils.printLine("Invalid Date format, try again");
            waitForEnter();
        }
        utils.printLine("User uptated!");
        waitForEnter();
    }
}


















