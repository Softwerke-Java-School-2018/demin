package com.miros.controller;

import com.miros.Main;
import com.miros.data.entity.Device;
import com.miros.data.enums.DeviceColor;

public class FindController extends BaseController {

    void deviceIdFind(Integer id){
        System.out.println(Main.deviceList.get(id));
    }

    void deviceColorFind(String color){
        for ()

    }

    void deviceTypeFind(Integer id){

    }


    public static <T extends Enum<?>> T searchEnum(Class<T> enumeration,
                                                   String search) {
        for (T each : enumeration.getEnumConstants()) {
            if (each.name().compareToIgnoreCase(search) == 0) {
                return each;
            }
        }
        return null;
    }
}
