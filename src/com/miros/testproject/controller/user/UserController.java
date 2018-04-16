package com.miros.testproject.controller.user;
import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Контроллер для пользователя
 */

public class UserController extends BaseController {
    private static UserController userController = new UserController();

    public UserController(){}

    public static UserController getInstance(){
        return userController;
    }
    /**
     * Create new user
     * @param name
     * @param surname
     * @param patronymic
     * @param localDate
     * @return
     */
    public void create(String name, String surname, String patronymic, LocalDate localDate) {
        UserDAO.userDAO.add(new User(name, surname, patronymic, localDate));
        Utils.printLine("User created");
        waitForEnter();
    }
    public void delete(Integer id){
        UserDAO.userDAO.remove(id);
        Utils.printLine("User deleted");
        waitForEnter();
    }
    public void update(Integer id, String name, String surname, String patronymic, String birthDay) throws RuntimeException{
        if(!name.equals("")){
            UserDAO.userDAO.get(id).setName(name);
        }
        if(!surname.equals("")){
            UserDAO.userDAO.get(id).setSurname(surname);
        }
        if(!patronymic.equals("")){
            UserDAO.userDAO.get(id).setSurname(surname);
        }
        if(!surname.equals("")){
            UserDAO.userDAO.get(id).setSurname(surname);
        }
        LocalDate localDate;
        if(!birthDay.equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
            localDate = LocalDate.parse(birthDay, formatter);
            UserDAO.userDAO.get(id).setBirthDay(localDate);
        }
        Utils.printLine("User uptated");
        waitForEnter();
    }
}


















