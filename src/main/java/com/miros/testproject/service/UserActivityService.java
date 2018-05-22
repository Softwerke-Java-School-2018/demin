package com.miros.testproject.service;

import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.entity.UserActivity;

import java.util.stream.Stream;
import java.util.*;

/**
 * Service layer for UserActivity
 */
public class UserActivityService {
    private List<UserActivity> userActivityDAO = UserActivityDAO.getInstance().getInstanceList();

    public Optional<UserActivity> save(UserActivity userActivity) {
        Optional<UserActivity> optUserActivity = Optional.ofNullable(userActivity);
        boolean result = optUserActivity.isPresent();
        if (result) {
            userActivityDAO.add(optUserActivity.get());
        }
        return optUserActivity;
    }

    public UserActivity find(int id) {
        return userActivityDAO.get(id);
    }

    public UserActivity delete(int id) {
        return userActivityDAO.remove(id);
    }

    public Optional<UserActivity> delete(UserActivity userActivity) {
        Optional<UserActivity> optionalUserActivity = Optional.ofNullable(userActivity);
        boolean result = optionalUserActivity.isPresent();
        if (result) {
            userActivityDAO.remove(optionalUserActivity.get());
        }
        return optionalUserActivity;
    }

    public Stream<UserActivity> findAll() {
        return userActivityDAO.stream();
    }

    public void clear() {
        userActivityDAO.clear();
    }

    /**
     * return true if entity exist
     *
     * @param id entity dd
     * @return
     */
    public boolean exist(int id) {
        Optional<UserActivity> device = userActivityDAO.stream()
                .filter(s -> s.getId() == id)
                .findAny();
        return device.isPresent();
    }
}
