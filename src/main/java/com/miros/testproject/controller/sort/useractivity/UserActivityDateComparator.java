package com.miros.testproject.controller.sort.useractivity;

import com.miros.testproject.data.entity.UserActivity;

import java.util.Comparator;

public class UserActivityDateComparator implements Comparator<UserActivity> {
    @Override
    public int compare(UserActivity o1, UserActivity o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
