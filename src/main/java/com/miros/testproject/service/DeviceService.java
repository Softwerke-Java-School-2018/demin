package com.miros.testproject.service;

import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.exception.RuntimeEx;

import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Stream;


/**
 * Service layer for Devices
 */
public class DeviceService {
    private List<Device> deviceDAO = DeviceDAO.getInstance().getDeviceList();
    private volatile Device device;

    public boolean save(Device device) throws IndexOutOfBoundsException {
        return deviceDAO.add(device);
    }

    public Device find(int id) throws IndexOutOfBoundsException {
        device = deviceDAO.get(id);
        return device;
    }

    public Device delete(int id) throws NullPointerException, IllegalArgumentException {
        device = deviceDAO.get(id);
        return device;
    }

    public boolean delete(Device device) throws IndexOutOfBoundsException {
        return deviceDAO.remove(device);
    }

    public Stream<Device> findAll()  {
        return deviceDAO.stream();
    }

    public boolean exist(int id) throws RuntimeEx {
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
