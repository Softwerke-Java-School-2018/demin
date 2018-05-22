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

    public Optional<Device> save(Device device) throws IndexOutOfBoundsException {
        Optional<Device> optionalDevice = Optional.ofNullable(device);
        boolean result = optionalDevice.isPresent();
        if (result) {
            deviceDAO.add(optionalDevice.get());
        }
        return optionalDevice;
    }

    public Device find(int id) throws IndexOutOfBoundsException {
        device = deviceDAO.get(id);
        return device;
    }

    public Device delete(int id) throws NullPointerException, IllegalArgumentException {
        return deviceDAO.remove(id);
    }

    public Optional<Device> delete(Device device) throws IndexOutOfBoundsException {
        Optional<Device> optionalDevice = Optional.ofNullable(device);
        boolean result = optionalDevice.isPresent();
        if (result) {
            deviceDAO.remove(optionalDevice.get());
        }
        return optionalDevice;
    }

    public Stream<Device> findAll() {
        return deviceDAO.stream();
    }

    public void clear() throws UnsupportedOperationException {
        deviceDAO.clear();
    }

    /**
     * return true if entity exist
     * @param id
     * @return
     */
    public boolean exist(int id) {
        Optional<Device> device = deviceDAO.stream()
                .filter(s -> s.getId() == id)
                .findAny();
        return device.isPresent();
    }
}
