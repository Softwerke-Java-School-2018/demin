package com.miros.testproject.data.DAO;

import com.miros.testproject.data.entity.Device;
import java.util.*;



public class DeviceDAO {
    private static DeviceDAO deviceDAO = new DeviceDAO();
    private List<Device> deviceList = new ArrayList();
    public static DeviceDAO getInstance() {
        return deviceDAO;
    }
    public List<Device> getInstanceList() {
        return deviceList;
    }
}


