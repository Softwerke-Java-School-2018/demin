package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.exception.ParseException;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.BaseClassService;
import com.miros.testproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Controller for Create, Delete, Update User Entity
 */
public class UserController extends BaseController {
    private UserService userService = BaseClassService.getInstance().getUserService();
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private volatile User user;

    /**
     * Create new user
     *
     * @param name
     * @param surname
     * @param patronymic
     * @param birthDay
     * @return
     */
    public Optional<User> create(String name, String surname, String patronymic, String birthDay) {
        try {
            localDate = dateParser(birthDay);
            user = User.builder()
                    .setName(name)
                    .setSurname(surname)
                    .setPatronymic(patronymic)
                    .setBirthDay(localDate)
                    .build();
            userService.save(user);
            log.info("User create: Create new user with id: " + user.getId());
            waitForEnter();
            return Optional.of(user);
        } catch (ParseException e) {
            utils.printLine("Invalid Date format, try again");
            log.info("User create: Invalid date format");
            waitForEnter();
        } catch (RuntimeEx e) {
            log.info("User create: Save new user exception", e);
        }
        return empty;
    }

    /**
     * Delete current User
     *
     * @param id
     */

    public Optional<User> delete(int id) {
        try {
            user = userService.find(id);
            userService.delete(user);
            log.info("User delete id: " + id);
            utils.printLine("User deleted");
            waitForEnter();
            return Optional.of(user);
        } catch (RuntimeEx e) {
            utils.printLine("User with " + id + " id number, doesn't exist");
            log.info("Runtime :", e);
            waitForEnter();
        }
        return empty;
    }

    /**
     * Update User by Several parametres
     *
     * @param id
     * @param name
     * @param surname
     * @param patronymic
     * @param birthDay
     */

    public Optional<User> update(int id, String name, String surname, String patronymic, String birthDay) {
        try {
            user = userService.find(id);
            if (!"".equals(birthDay)) {
                dateParser(birthDay);
                user.setBirthDay(localDate);
                log.info("User update: Birthday setted");
            }
            if (!"".equals(name)) {
                user.setName(name);
                log.info("User update: Name setted");
            }
            if (!"".equals(surname)) {
                user.setSurname(surname);
                log.info("User update: Surname setted");
            }
            if (!"".equals(patronymic)) {
                user.setPatronymic(patronymic);
                log.info("User update: Patronymic setted");
            }
            utils.printLine("User uptated!");
            log.info("User update: user id: " + id + " updated");
            waitForEnter();
        } catch (RuntimeEx e) {
            utils.printLine("User with " + id + " id number, doesn't exist");
            log.info("User update: user doesn't exist", e);
            waitForEnter();
        } catch (ParseException ex) {
            utils.printLine("Invalid Date format, try again");
            log.info("User update: Invalid date Format", ex);
            waitForEnter();
        }
        return empty;
    }
}


















