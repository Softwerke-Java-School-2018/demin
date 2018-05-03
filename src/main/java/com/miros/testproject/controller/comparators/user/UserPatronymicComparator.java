package com.miros.testproject.controller.comparators.user;

import com.miros.testproject.data.entity.User;

import java.util.Comparator;

public class UserPatronymicComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getPatronymic().compareTo(user2.getPatronymic());
    }
}
