package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Контроллер для поиска пользователей
 */

public class UserFindController extends BaseController {

    private static UserFindController userFindController = new UserFindController();

    public  UserFindController(){}

    public static UserFindController getInstance(){
        return userFindController;
    }

    public void userIdFind(Integer id){
        System.out.println(Main.userList.get(id));
        waitForEnter();
    }

    public void userNameFind(String name){
        for (User user : Main.userList){
            if(user.getName().equalsIgnoreCase(name)){
                System.out.println(user);
            }
        }
        waitForEnter();
    }

    public void localDateFind(String date){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
        for (User user : Main.userList){
           if(user.getBirthDay().equals(localDate)){
               System.out.println(user);
           }
        }
        waitForEnter();
    }

    public void showAllUsers(){
        for(User user : Main.userList){
            System.out.println(user);
        }
        waitForEnter();
    }


//Сортировка
    public void sortNameUsers(){
        for(User user : Main.userList){
            System.out.println(user);
        }
    }
}
