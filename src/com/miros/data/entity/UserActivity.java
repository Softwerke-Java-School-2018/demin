package com.miros.data.entity;

import java.time.LocalDate;

public class UserActivity {
    private  static long userActivityId=0;
    private long id;
    private User user;
    private Device device;
    private LocalDate localDate;

    public UserActivity(){};

    public UserActivity(User user, Device device, LocalDate localDate){
        this.id=userActivityId++;
        this.user = user;
        this.device = device;
        this.localDate = localDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public User getUser() {
        return user;
    }

    public Device getDevice() {
        return device;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
