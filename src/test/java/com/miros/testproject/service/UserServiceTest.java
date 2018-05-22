package com.miros.testproject.service;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.data.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.util.Optional;

public class UserServiceTest {
    private UserService userService;
    private DeviceService deviceService;
    private UserActivityService userActivityService;



    @Before
    public void init() {
        deviceService = BaseClassService.getInstance().getDeviceService();
        userService = BaseClassService.getInstance().getUserService();
        userActivityService = BaseClassService.getInstance().getUserActivityService();
        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
    }

    @Test
    public void save_user_success() throws NullPointerException {
        LocalDate localDate = LocalDate.now();
        User testUser = User.builder()
                .setName("testName")
                .setSurname("testSurname")
                .setPatronymic("testPatronymic")
                .setBirthDay(localDate)
                .build();
        Optional<User> result = userService.save(testUser);
        Assert.assertEquals(result.isPresent(), true);
        Assert.assertEquals(result.get().getName(), "testName");
        Assert.assertEquals(result.get().getSurname(), "testSurname");
        Assert.assertEquals(result.get().getPatronymic(), "testPatronymic");
        Assert.assertEquals(result.get().getBirthDay(), localDate);
        Assert.assertEquals(result.get().getId(), testUser.getId());
    }

    @Test
    public void save_user_null() throws NullPointerException {
        Optional<User> result = userService.save(null);
        Assert.assertEquals(result.isPresent(), false);
    }

    @Test
    public void delete_user_success() throws IndexOutOfBoundsException {
        User user = userService.delete(1);
        User user2 = userService.delete(2);
        Assert.assertEquals(user.getId(), 2);
        Assert.assertEquals(user2.getId(), 4);
        Assert.assertEquals(User.class, user.getClass());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void delete_user_throws_IndexOutOfBounds() throws IndexOutOfBoundsException {
        userService.delete(100);
    }

    @Test
    public void find_user_success() throws IndexOutOfBoundsException {
        User user = userService.find(4);
        Assert.assertNotNull(user);
        Assert.assertEquals(User.class, user.getClass());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void find_user_by_throws_IndexOutBounds() throws IndexOutOfBoundsException {
        userService.find(-2);
    }

    @Test
    public void findAll() {
        Optional<User> opt = userService.findAll().findAny();
        Assert.assertEquals(opt.isPresent(), true);
    }

    @Test
    public void exist() {
        boolean exist = userService.exist(2);
        boolean exist2 = userService.exist(100);
        Assert.assertEquals(exist, true);
        Assert.assertEquals(exist2, false);
    }

    @After
    public void clear() {
        userService.clear();
        deviceService.clear();
        userActivityService.clear();
        User.refreshAtomicInteger();
    }
}