package com.miros.testproject.controller.user;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.comparators.UserBirthDayComparator;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.TreeSet;

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
        System.out.println(UserDAO.userDAO.get(id));
        waitForEnter();
    }

    public void nameFind(String name){
        for (User user : UserDAO.userDAO){
            if(user.getName().equalsIgnoreCase(name)){
                System.out.println(user);
            }
        }
        waitForEnter();
    }

    public void dateFind(String date){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
        for (User user : UserDAO.userDAO){
           if(user.getBirthDay().equals(localDate)){
               System.out.println(user);
           }
        }
        waitForEnter();
    }

    public void showAll(){
        Comparator<User> comparator = new UserBirthDayComparator();
        TreeSet<User> users = new TreeSet<>(comparator);

        UserDAO.userDAO
                .stream()
                .forEach(s-> Utils.printLine(s));
        waitForEnter();
    }
}
