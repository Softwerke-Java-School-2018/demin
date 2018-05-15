package com.miros.testproject.data.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private String userName = "userName";
    private String userSurname = "userSurname";
    private String userPatronymic = "userPatronymic";
    private LocalDate date = LocalDate.now();

    private User testUser;
    private String testUserName = "testUserName";
    private String testUserSurname = "testUserSurname";
    private String testUserPatronymic = "testUserPatronymic";

    @Before
    public void init() {
        user = User.builder()
                .setName(userName)
                .setSurname(userSurname)
                .setPatronymic(userPatronymic)
                .setBirthDay(date)
                .build();
    }

    @Test
    public void getters_setters_success() {
        testUser = user.getUser();
        testUser.setName(testUserName);
        testUser.setSurname(testUserSurname);
        testUser.setPatronymic(testUserPatronymic);

        Assert.assertEquals(User.class, testUser.getClass());
        Assert.assertEquals(user.getId(), testUser.getId());
        Assert.assertEquals(testUserName, testUser.getName());
        Assert.assertEquals(testUserSurname, testUser.getSurname());
        Assert.assertEquals(testUserPatronymic, testUser.getPatronymic());
    }
}