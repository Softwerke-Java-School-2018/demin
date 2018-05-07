package com.miros.testproject.data;

        import com.miros.testproject.data.entity.Device;
        import com.miros.testproject.data.entity.User;

        import java.util.ArrayList;
        import java.util.List;

        import com.miros.testproject.data.entity.UserActivity;


/**
 * Temporary data with all types Entity lists.
 * It's for sort manipulations
 */
public class TempData {
    private static TempData tempData = new TempData();
    private List<User> tempUserList = new ArrayList();
    private List<Device> tempDeviceList = new ArrayList();
    private List<UserActivity> tempUserActivityList = new ArrayList();

    public static TempData getInstance() {
        return tempData;
    }

    public List<UserActivity> getTempUserActivityList() {
        return tempUserActivityList;
    }

    public List<Device> getTempDeviceList() {
        return tempDeviceList;
    }

    public List<User> getTempUserList() {
        return tempUserList;
    }
}
