package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.User;
import java.time.LocalDate;


public class UserController extends BaseController  {

    public void execute(String str){
    }

    public UserController(){
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
        Main.userList.add(new User(name, surname, patronymic, localDate));
        System.out.println("Пользователь создан");
        baseView.baseMenu();
    }

    public void delete(Integer id){
        Main.userList.remove(id);
        baseView.baseMenu();
    }

    public void update(Integer id, String name, String surname, String patronymic, LocalDate localDate){
        if(!name.equals("")){
            Main.userList.get(id).setName(name);
        }
        if(!surname.equals("")){
            Main.userList.get(id).setSurname(surname);
        }
        if(!patronymic.equals("")){
            Main.userList.get(id).setSurname(surname);
        }
        if(!surname.equals("")){
            Main.userList.get(id).setSurname(surname);
        }
        if(!Main.userList.get(id).getBirthDay().equals(localDate)){
            Main.userList.get(id).setBirthDay(localDate);
        }
        baseView.baseMenu();
    }
}


















