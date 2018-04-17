package com.miros.testproject.data.DAO;

import com.miros.testproject.data.entity.User;

import java.util.ArrayList;

public class UserDAO extends ArrayList<User> {
    private static UserDAO userDAO = new UserDAO();

    public static UserDAO getInstance() {
        return userDAO;
    }
}

