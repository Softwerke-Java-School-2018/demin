package com.miros.controller.comparators;

import com.miros.data.entity.User;

import java.util.Comparator;

/**
 * КОМПАРАТОР НЕДОДЕЛАН
 */

public class UserNameComparator implements Comparator<User> {


    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}


