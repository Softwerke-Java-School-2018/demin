package com.miros.controller;

import com.miros.Main;
import com.miros.data.DateBase;
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

    public void idFind(Integer id){
        System.out.println(DateBase.userList.get(id));
        waitForEnter();
    }

    public void nameFind(String name){
        for (User user : DateBase.userList){
            if(user.getName().equalsIgnoreCase(name)){
                System.out.println(user);
            }
        }
        waitForEnter();
    }

    public void dateFind(String date){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
        for (User user : DateBase.userList){
           if(user.getBirthDay().equals(localDate)){
               System.out.println(user);
           }
        }
        waitForEnter();
    }

    public void showAll(){
        for(User user : DateBase.userList){
            System.out.println(user);
        }
        waitForEnter();
    }
}
