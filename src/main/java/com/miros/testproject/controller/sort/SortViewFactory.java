package com.miros.testproject.controller.sort;

import com.miros.testproject.BaseClass;
import com.miros.testproject.Main;
import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.controller.activity.UserActivityFindController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.view.SortView;
import com.miros.testproject.view.activity.UserActivitySortView;
import com.miros.testproject.view.device.DeviceSortView;
import com.miros.testproject.view.user.UserSortView;

/**
 * Fabric for creating sortViews by
 * controllers
 */

public class SortViewFactory extends BaseClass {
    public SortView getSortView(BaseClassController baseClassController) {
        String str = utils.readLine();
        if ("".equals(str)) {
            Main.getMainMenuView().baseMenu();
        }
        if ("s".equals(str)) {
            if (baseClassController instanceof UserFindController) {
                return new UserSortView();
            }
            if (baseClassController instanceof DeviceFindController) {
                return new DeviceSortView();
            }
            if (baseClassController instanceof UserActivityFindController) {
                return new UserActivitySortView();
            }
        }
        return null;
    }
}
