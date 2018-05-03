package com.miros.testproject.data.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserActivity {
    private static int userActivityId = 0;
    private int id;
    private User user;
    private List<Device> deviceList;
    private LocalDate localDate;

    public UserActivity(User user, List<Device> deviceList, LocalDate localDate) {
        this.id = userActivityId++;
        this.user = user;
        this.deviceList = deviceList;
        this.localDate = localDate;
    }

    public UserActivity getUserActivity() {
        return this;
    }
}
