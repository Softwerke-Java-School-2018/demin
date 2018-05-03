package com.miros.testproject.data.DAO;

import com.miros.testproject.data.entity.User;

import java.util.*;


public class UserDAO {
    private static UserDAO userDAO = new UserDAO();

    private List<User> userList = new ArrayList();

    public static UserDAO getInstance() {
        return userDAO;
    }

    public List<User> getInstanceList() {
        return userList;
    }
}

