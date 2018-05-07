package com.miros.testproject.data.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserActivity {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private User user;
    private List<Device> deviceList;
    private LocalDate localDate;

    public UserActivity(User user, List<Device> deviceList, LocalDate localDate) {
        this.id = atomicInteger.incrementAndGet();
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
