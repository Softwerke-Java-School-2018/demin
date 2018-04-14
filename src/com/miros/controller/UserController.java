package com.miros.controller;
import com.miros.Main;
import com.miros.data.DateBase;
import com.miros.data.entity.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Контроллер для пользователя
 */

public class UserController extends BaseController  {
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
        DateBase.userList.add(new User(name, surname, patronymic, localDate));
        System.out.println("User created");
        waitForEnter();
    }
    public void delete(Integer id){
        DateBase.userList.remove(id);
        System.out.println("User deleted");
        waitForEnter();
    }
    public void update(Integer id, String name, String surname, String patronymic, String birthDay){
        if(!name.equals("")){
            DateBase.userList.get(id).setName(name);
        }
        if(!surname.equals("")){
            DateBase.userList.get(id).setSurname(surname);
        }
        if(!patronymic.equals("")){
            DateBase.userList.get(id).setSurname(surname);
        }
        if(!surname.equals("")){
            DateBase.userList.get(id).setSurname(surname);
        }
        LocalDate localDate;
        if(!birthDay.equals("")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            localDate = LocalDate.parse(birthDay, formatter);
            DateBase.userList.get(id).setBirthDay(localDate);
        }
        System.out.println("User uptated");
        waitForEnter();
    }
}


















