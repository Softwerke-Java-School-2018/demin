package com.miros.testproject.util;

import com.miros.testproject.BaseClass;
import com.miros.testproject.Main;
import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.controller.activity.UserActivityFindController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.view.BaseSort;

public class Sort extends BaseClass {
    public boolean sortFunction(BaseClassController baseClassController) {
        String str = utils.readLine();
        if ("".equals(str)) {
            Main.getMainMenuView().baseMenu();
        }
        if ("s".equals(str)) {
            BaseSort baseSort = Main.getMainMenuView().getBaseSort();
            if (baseClassController instanceof UserFindController) {
                baseSort.getUserSortView().userSort();
                return true;
            }
            if (baseClassController instanceof DeviceFindController) {
                baseSort.getDeviceSortView().deviceSort();
                return true;
            }
            if (baseClassController instanceof UserActivityFindController) {
                baseSort.getUserActivitySortView().userActivitySort();
                return true;
            }
        } else {
            waitForEnter();
        }
        return false;
    }
}


