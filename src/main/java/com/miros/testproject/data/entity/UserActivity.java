package com.miros.testproject.data.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserActivity {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private User user;
    private List<Device> deviceList;
    private LocalDate localDate;

    public UserActivity(User user, List<Device> deviceList, LocalDate localDate) {
        atomicInteger.incrementAndGet();
        this.user = user;
        this.deviceList = deviceList;
        this.localDate = localDate;
    }

    public synchronized UserActivity getUserActivity() {
        return this;
    }

    public int getId() {
        return id;
    }
}
