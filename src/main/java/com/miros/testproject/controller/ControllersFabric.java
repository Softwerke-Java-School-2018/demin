package com.miros.testproject.controller;

import com.miros.testproject.controller.activity.UserActivityController;
import com.miros.testproject.controller.activity.UserActivityFindController;
import com.miros.testproject.controller.activity.UserActivitySortController;
import com.miros.testproject.controller.device.DeviceController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.controller.device.DeviceSortController;
import com.miros.testproject.controller.user.UserController;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.controller.user.UserSortController;
import java.util.Optional;

/**
 * Fabric for generation app controllers
 */

public class ControllersFabric {

    public static <T> Optional<BaseController> getController(Class<T> clazz) {
        if (clazz.isAssignableFrom(UserController.class)) {
            return Optional.of(new UserController());
        }
        if (clazz.isAssignableFrom(DeviceController.class)) {
            return Optional.of(new DeviceController());
        }
        if (clazz.isAssignableFrom(UserActivityController.class)) {
            return Optional.of(new UserActivityController());
        }
        if (clazz.isAssignableFrom(UserFindController.class)) {
            return Optional.of(new UserFindController());
        }
        if (clazz.isAssignableFrom(DeviceFindController.class)) {
            return Optional.of(new DeviceFindController());
        }
        if (clazz.isAssignableFrom(UserActivityFindController.class)) {
            return Optional.of(new UserActivityFindController());
        }
        if (clazz.isAssignableFrom(UserSortController.class)) {
            return Optional.of(new UserSortController());
        }
        if (clazz.isAssignableFrom(DeviceSortController.class)) {
            return Optional.of(new DeviceSortController());
        }
        if (clazz.isAssignableFrom(UserActivitySortController.class)) {
            return Optional.of(new UserActivitySortController());
        }
        return Optional.empty();
    }
}

