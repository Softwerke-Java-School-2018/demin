package com.miros.testproject.service;

import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.exception.RuntimeEx;
import com.sun.istack.internal.NotNull;


import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Stream;

public class DeviceService {
    private List<Device> deviceDAO = DeviceDAO.getInstance().getDeviceList();
    private volatile Device device;

    public boolean save(@NotNull Device device) throws RuntimeEx {
        return deviceDAO.add(device);
    }

    public Device find(@NotNull int id) throws IndexOutOfBoundsException {
        device = deviceDAO.get(id);
        return device;
    }

    public Device delete(@NotNull int id) throws RuntimeEx {
        device = deviceDAO.get(id);
        return device;
    }

    public boolean delete(@NotNull Device device) throws RuntimeEx {
        return deviceDAO.remove(device);
    }

    public Stream<Device> findAll() throws RuntimeEx {
        return deviceDAO.stream();
    }

    public boolean exist(@NotNull int id) throws RuntimeEx {
        int size = deviceDAO.stream()
                .filter(s -> s.getId() == id)
                .collect(Collectors.toList())
                .size();

        if (size > 0) {
            return true;
        }
        return false;
    }
}
