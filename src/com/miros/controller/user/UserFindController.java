package com.miros.controller.user;

import com.miros.controller.BaseController;
import com.miros.controller.comparators.UserNameComparator;
import com.miros.controller.comparators.UserSurnameComparator;
import com.miros.data.DAO.UserDAO;
import com.miros.data.entity.User;

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
        Comparator<User> comparator = new UserNameComparator().thenComparing(new UserSurnameComparator());
        TreeSet<User> users = new TreeSet(comparator);

        for(User user : UserDAO.userDAO){
            users.add(user);
        }
        for (User user : users){
            System.out.println(user);
        }
        waitForEnter();
    }
}
