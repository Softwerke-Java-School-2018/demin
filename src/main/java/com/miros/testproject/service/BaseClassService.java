package com.miros.testproject.service;

public class BaseClassService {
    private static final BaseClassService baseClassService = new BaseClassService();
    //EntityServices init
    private final UserActivityService userActivityService = new UserActivityService();
    private final UserService userService = new UserService();
    private final DeviceService deviceService = new DeviceService();

    public static BaseClassService getInstance() {
        return baseClassService;
    }

    public UserActivityService getUserActivityService() {
        return userActivityService;
    }

    public DeviceService getDeviceService() {
        return deviceService;
    }

    public UserService getUserService() {
        return userService;
    }
}
