package com.miros.testproject.data.DAO;

import com.miros.testproject.data.entity.UserActivity;

import java.util.ArrayList;

public class UserActivityDAO extends ArrayList<UserActivity> {
    static UserActivityDAO userActivityDAO = new UserActivityDAO();

    public static UserActivityDAO getInstance() {
        return userActivityDAO;
    }
}
