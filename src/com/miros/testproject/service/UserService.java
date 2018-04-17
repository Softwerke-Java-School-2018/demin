package com.miros.testproject.service;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.data.entity.User;

import java.util.stream.Collectors;

public class UserService {
    private static UserService userService = new UserService();
    private static UserDAO userDAO = UserDAO.getInstance();
    public static UserService getInstance() {
        return userService;
    }
    public boolean exist(int id){
        int size = userDAO.stream()
                .filter(s-> s.getId() == id)
                .collect(Collectors.toList())
                .size();
        if(size>0){
            return true;
        }
        return false;
    }

    public User idFind(int id) throws IndexOutOfBoundsException{
        return userDAO.get(id);
    }

}
