package com.miros.testproject.controller.user;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.exception.ParseException;
import com.miros.testproject.exception.RuntimeEx;
import com.miros.testproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Optional;

public class UserController extends BaseClassController {
    private UserService userService = new UserService();
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

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
            User newUser = new User(name, surname, patronymic, localDate);
            userService.save(newUser);
            utils.printLine("User created");
            log.info("User create: Create new user with id: " + newUser.getId());
            waitForEnter();
            return Optional.of(newUser);
        } catch (ParseException e) {
            utils.printLine("Invalid Date format, try again");
            log.info("User create: Invalid date format");
            waitForEnter();
        } catch (RuntimeEx e) {
            log.info("User create: Save new user exception", e);
        } finally {
            return empty;
        }
    }

    /**
     * @param id
     */

    public Optional<User> delete(int id) {
        try {
            User user = userService.find(id);
            userService.delete(user);
            log.info("User delete id: " + id);
            utils.printLine("User deleted");
            waitForEnter();
            return Optional.of(user);
        } catch (RuntimeEx e) {
            utils.printLine("User with " + id + " id number, doesn't exist");
            log.info("Runtime :", e);
            waitForEnter();
        } finally {
            return empty;
        }
    }

    /**
     * @param id
     * @param name
     * @param surname
     * @param patronymic
     * @param birthDay
     */

    public Optional<User> update(int id, String name, String surname, String patronymic, String birthDay) {
        try {
            User user = userService.find(id);
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
        } finally {
            return empty;
        }
    }
}


















