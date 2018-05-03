package com.miros.testproject.data.DAO;

import com.miros.testproject.data.entity.UserActivity;

import java.util.ArrayList;
import java.util.*;

public class UserActivityDAO {
    private static UserActivityDAO userActivityDAO = new UserActivityDAO();

    private List<UserActivity> userActivityList = new ArrayList();

    public static UserActivityDAO getInstance() {
        return userActivityDAO;
    }

    public List<UserActivity> getInstanceList() {
        return userActivityList;
    }
}
