package com.miros.testproject.service;

import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.exception.RuntimeEx;

import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Stream;

public class DeviceService {
    private List<Device> deviceDAO = DeviceDAO.getInstance().getDeviceList();

    public boolean save(Device device) throws RuntimeEx {
        return deviceDAO.add(device);
    }

    public Device find(int id) throws RuntimeEx {
        return deviceDAO.get(id);
    }

    public Device delete(int id) throws RuntimeEx {
        return deviceDAO.remove(id);
    }

    public boolean delete(Device device)throws RuntimeEx {
        return deviceDAO.remove(device);
    }

    public Stream<Device> findAll() throws RuntimeEx {
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
