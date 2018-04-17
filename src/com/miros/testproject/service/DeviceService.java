package com.miros.testproject.service;

import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.entity.Device;

import java.util.stream.Collectors;

public class DeviceService {
    private static DeviceService deviceService = new DeviceService();
    private static DeviceDAO deviceDAO = DeviceDAO.getInstance();

    public static DeviceService getInstance() {
        return deviceService;
    }

    public boolean exist(int id){
        int size = deviceDAO.stream()
                .filter(s-> s.getId() == id)
                .collect(Collectors.toList())
                .size();
        if(size>0){
            return true;
        }
        return false;
    }

    public Device idFind(int id) throws IndexOutOfBoundsException{
         return deviceDAO.get(id);
    }
}
