package com.miros.testproject.service;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserActivityServiceTest {
    private DeviceService deviceService;
    private UserService userService;
    private UserActivityService userActivityService;
    private String deviceModel = "Nokia44567";
    private List<Device> deviceList = new ArrayList<>();
    private User testUser;

    @Before
    public void init() {
        deviceService = BaseClassService.getInstance().getDeviceService();
        userService = BaseClassService.getInstance().getUserService();
        userActivityService = BaseClassService.getInstance().getUserActivityService();
        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
        deviceList.add(deviceService.find(1));
        deviceList.add(deviceService.find(2));
        testUser = userService.find(1);
    }

    @Test
    public void save_userActivity_success() throws NullPointerException {
        UserActivity userActivity = UserActivity.builder()
                .setDate(LocalDate.now())
                .setDeviceList(deviceList)
                .setUser(testUser)
                .build();

        Optional<UserActivity> result = userActivityService.save(userActivity);
        Assert.assertEquals(result.isPresent(), true);
        Assert.assertEquals(result.get().getUser(), userActivity.getUser());
        Assert.assertEquals(result.get().getDate(), userActivity.getDate());
        Assert.assertEquals(result.get().getDeviceList(), userActivity.getDeviceList());
        Assert.assertEquals(result.get().getId(), userActivity.getId());
    }


    @Test
    public void find_userActivity_success() throws IndexOutOfBoundsException {
        UserActivity userActivity = userActivityService.find(1);
        Assert.assertNotNull(userActivity);
        Assert.assertEquals(UserActivity.class, userActivity.getClass());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void find_userActivity_by_throws_IndexOutBounds() throws IndexOutOfBoundsException {
        deviceService.find(-2);
    }

    @Test
    public void findAll() {
        Optional<UserActivity> opt = userActivityService.findAll().findAny();
        Assert.assertEquals(opt.isPresent(), true);
    }

    @Test
    public void exist() {
        boolean exist = userActivityService.exist(1);
        boolean exist2 = userActivityService.exist(100);
        Assert.assertEquals(exist, true);
        Assert.assertEquals(exist2, false);
    }

    @Test
    public void save_userActivity_null() throws NullPointerException {
        Optional<UserActivity> result = userActivityService.save(null);
        Assert.assertEquals(result.isPresent(), false);
    }

    @Test
    public void delete_userActivity_success() throws IndexOutOfBoundsException {
        UserActivity userActivity = userActivityService.delete(0);
        Assert.assertEquals(UserActivity.class, userActivity.getClass());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void delete_userActivity_throws_IndexOutOfBounds() throws IndexOutOfBoundsException {
        userActivityService.delete(100);
    }

    @After
    public void clear() {
        deviceService.clear();
        userService.clear();
        userActivityService.clear();
        UserActivity.refreshAtomicInteger();
    }
}