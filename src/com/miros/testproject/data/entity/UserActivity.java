package com.miros.testproject.data.entity;

import java.time.LocalDate;
import java.util.List;

public class UserActivity {
    private  static int userActivityId=0;
    private int id;
    private User user;
    private List<Device> deviceList;
    private LocalDate localDate;

    public UserActivity(User user, List<Device> deviceList, LocalDate localDate){
        this.id=userActivityId++;
        this.user = user;
        this.deviceList = deviceList;
        this.localDate = localDate;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public User getUser() {
        return user;
    }
    public UserActivity getUserActivity() {
        return this;
    }
    public List<Device> getDeviceList() {
        return deviceList;
    }
    public int getId() {
        return id;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    @Override
    public String toString() {
        return  id + " " +
                user.toString() +"\n"+
                deviceList.toString()+"\n"+
                localDate.toString();
    }
}
