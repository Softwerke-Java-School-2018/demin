package com.miros.testproject.data.DAO;

import com.miros.testproject.Utils;
import com.miros.testproject.data.entity.Device;
import java.util.*;
import java.util.stream.Collectors;


public class DeviceDAO extends ArrayList<Device> {

    private static DeviceDAO deviceDAO = new DeviceDAO();

    public static DeviceDAO getInstance() {
        return deviceDAO;
    }


}


