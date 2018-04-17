package com.miros.testproject.service;

import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.entity.UserActivity;

import java.util.stream.Stream;

public class UserActivityService {
    private static UserActivityService userActivityService = new UserActivityService();
    private static UserActivityDAO userActivityDAO = UserActivityDAO.getInstance();

    public static UserActivityService getInstance() {
        return userActivityService;
    }

    public UserActivity save(UserActivity userActivity){
         userActivityDAO.add(userActivity);
         return userActivity;
    }

    public UserActivity find(int id) throws IndexOutOfBoundsException{
        return userActivityDAO.get(id);
    }

    public Stream<UserActivity> showAll(){
       return userActivityDAO.stream();
    }
}
