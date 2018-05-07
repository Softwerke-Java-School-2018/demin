package com.miros.testproject.controller.sort.user;

import com.miros.testproject.data.entity.User;

import java.util.Comparator;

public class UserSurnameComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return user1.getSurname().compareTo(user2.getSurname());
        }
}
