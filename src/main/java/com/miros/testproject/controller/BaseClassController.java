package com.miros.testproject.controller;

import com.miros.testproject.BaseClass;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

import com.miros.testproject.Main;
import com.miros.testproject.controller.activity.UserActivityFindController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.data.TempData;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.service.TempDataService;
import lombok.Data;

@Data
public abstract class BaseClassController extends BaseClass {
    protected static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected Comparator comparator;
    protected TempDataService tempDataService = new TempDataService();
    protected static final UserFindController userFindController = new UserFindController();
    protected static final DeviceFindController deviceFindController = new DeviceFindController();
    protected static final UserActivityFindController userActivityFindController = new UserActivityFindController();
}





















