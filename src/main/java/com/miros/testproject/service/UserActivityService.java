package com.miros.testproject.service;

import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.entity.UserActivity;
import com.sun.istack.internal.NotNull;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class UserActivityService {
    private  List<UserActivity> userActivityDAO = UserActivityDAO.getInstance().getInstanceList();
    private volatile UserActivity userActivity;

    public boolean save(@NotNull UserActivity userActivity){
        return userActivityDAO.add(userActivity);
    }

    public UserActivity find(@NotNull int id) {
        userActivity = userActivityDAO.get(id);
        return userActivity;
    }

    public UserActivity delete(@NotNull int id){
        userActivity = userActivityDAO.remove(id);
        return userActivity;
    }

    public boolean delete(@NotNull UserActivity userActivity){
        return userActivityDAO.remove(userActivity);
    }

    public Stream<UserActivity> findAll(){
       return userActivityDAO.stream();
    }

    public boolean exist(@NotNull int id) {
        int size = userActivityDAO.stream()
                .filter(s -> s.getId() == id)
                .collect(Collectors.toList())
                .size();
        if (size > 0) {
            return true;
        }
        return false;
    }
}
