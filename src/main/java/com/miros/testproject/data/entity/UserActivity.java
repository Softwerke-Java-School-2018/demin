package com.miros.testproject.data.entity;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserActivity {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private User user;
    private List<Device> deviceList;
    private LocalDate date;

    public UserActivity(Builder userActivityBuilder) {
        this.id = atomicInteger.incrementAndGet();
        this.user = userActivityBuilder.user;
        this.deviceList = userActivityBuilder.deviceList;
        this.date = userActivityBuilder.date;
    }

    public static void refreshAtomicInteger(){
        atomicInteger.set(0);
    }

    public synchronized UserActivity getUserActivity() {
        return this;
    }

    public int getId() {
        return id;
    }

    public static Builder builder() {
        return new UserActivity.Builder();
    }

    public static class Builder {
        private User user;
        private List<Device> deviceList;
        private LocalDate date;

        public Builder setUser(User user) {
            Optional<User> optUser = Optional.of(user);
            if (!optUser.isPresent()) {
                throw new NullPointerException();
            }
            this.user = optUser.get();
            return this;
        }

        public Builder setDeviceList(List<Device> deviceList) {
            Optional<List<Device>> optColor = Optional.of(deviceList);
            if (!optColor.isPresent()) {
                throw new NullPointerException();
            }
            this.deviceList = optColor.get();
            return this;
        }

        public Builder setDate(LocalDate localDate) {
            Optional<LocalDate> optDate = Optional.of(localDate);
            if (!optDate.isPresent()) {
                throw new DateTimeException("Birthday is null");
            }
            this.date = LocalDate.now();
            return this;
        }

        public UserActivity build() {
            return new UserActivity(this);
        }
    }
}
