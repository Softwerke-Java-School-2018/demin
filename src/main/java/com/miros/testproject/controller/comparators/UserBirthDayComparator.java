package com.miros.testproject.controller.comparators;

import com.miros.testproject.data.entity.User;

import java.util.Comparator;

public class UserBirthDayComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getBirthDay().compareTo(user2.getBirthDay());
    }
}
