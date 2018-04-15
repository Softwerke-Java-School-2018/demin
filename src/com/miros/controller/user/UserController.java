package com.miros.controller.user;
import com.miros.Utils;
import com.miros.controller.BaseController;
import com.miros.data.DAO.UserDAO;
import com.miros.data.entity.User;

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
     * Создание нового пользователя и переход в главное меню.
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
    public void update(Integer id, String name, String surname, String patronymic, String birthDay){
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            localDate = LocalDate.parse(birthDay, formatter);
            UserDAO.userDAO.get(id).setBirthDay(localDate);
        }
        Utils.printLine("User uptated");
        waitForEnter();
    }
}


















