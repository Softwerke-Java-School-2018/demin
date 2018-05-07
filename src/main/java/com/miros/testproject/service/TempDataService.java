package com.miros.testproject.service;

import com.miros.testproject.data.TempData;
import com.miros.testproject.data.entity.Device;
import com.miros.testproject.data.entity.User;
import com.miros.testproject.data.entity.UserActivity;
import java.util.List;


/**
 *
 */
public class TempDataService {
    private  List<User> tempDAOUserList = TempData.getInstance().getTempUserList();
    private  List<Device> tempDAODeviceList = TempData.getInstance().getTempDeviceList();
    private  List<UserActivity> tempDAOUserActivityList = TempData.getInstance().getTempUserActivityList();

    public void clearTempUserActivityList(){
        tempDAOUserActivityList.clear();
    }

    public void clearTempUserList(){
        tempDAOUserList.clear();
    }

    public void clearTempDeviceList(){
        tempDAODeviceList.clear();
    }

    public void setTempDAOUserActivityList(List<UserActivity> tempDAOUserActivityList) {
        tempDAOUserActivityList.addAll(tempDAOUserActivityList);
    }

    public void setTempDAODeviceList(List<Device> tempDAODeviceList) {
        tempDAODeviceList.addAll(tempDAODeviceList);
    }

    public void setTempDAOUserList(List<User> tempDAOUserList) {
        tempDAOUserList.addAll(tempDAOUserList);
    }

    public List<User> getTempDAOUserList(){
        return tempDAOUserList;
    }

    public List<Device> getTempDAODeviceList(){
        return tempDAODeviceList;
    }

    public List<UserActivity> getTempDAOUserActivityList(){
        return tempDAOUserActivityList;
    }
}
