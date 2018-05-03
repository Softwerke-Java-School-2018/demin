package com.miros.testproject.view;

import com.miros.testproject.view.activity.UserActivitySortView;
import com.miros.testproject.view.device.DeviceSortView;
import com.miros.testproject.view.user.UserSortView;
import lombok.Data;

@Data
public class BaseSort extends BaseClassView {
    private UserSortView userSortView = new UserSortView();
    private DeviceSortView deviceSortView = new DeviceSortView();
    private UserActivitySortView userActivitySortView = new UserActivitySortView();
}
