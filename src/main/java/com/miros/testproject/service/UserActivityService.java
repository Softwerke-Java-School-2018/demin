package com.miros.testproject.service;

import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.entity.UserActivity;
import lombok.NonNull;


import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

/**
 * Service layer for UserActivity
 */
public class UserActivityService {
    private  List<UserActivity> userActivityDAO = UserActivityDAO.getInstance().getInstanceList();

    public boolean save(UserActivity userActivity){
        return userActivityDAO.add(userActivity);
    }

    public UserActivity find(int id) {
        return userActivityDAO.get(id);
    }

    public UserActivity delete(int id){
        return userActivityDAO.remove(id);
    }

    public boolean delete(UserActivity userActivity){
        return userActivityDAO.remove(userActivity);
    }

    public Stream<UserActivity> findAll(){
       return userActivityDAO.stream();
    }

    /**
     * return true if entity exist
     * @param id entity dd
     * @return
     */
    public boolean exist(int id) {
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
