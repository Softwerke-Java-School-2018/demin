package com.miros.testproject.controller.sort;

import com.miros.testproject.BaseClass;
import com.miros.testproject.Main;
import com.miros.testproject.controller.activity.UserActivityFindController;
import com.miros.testproject.controller.device.DeviceFindController;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.view.SortView;
import com.miros.testproject.view.activity.UserActivitySortView;
import com.miros.testproject.view.device.DeviceSortView;
import com.miros.testproject.view.user.UserSortView;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Fabric for creating sortViews by
 * controllers
 */
public class SortClass extends BaseClass {
    private static SortClass sortClass = new SortClass();

    public static SortClass getInstance() {
        return sortClass;
    }

    /**
     * Fabric for Generate sortView Objects
     *
     * @param clazz
     * @return
     */
    public Optional<SortView> getSortView(Class clazz) {
        if (clazz.isAssignableFrom(UserFindController.class)) {
            return Optional.of(new UserSortView());
        }
        if (clazz.isAssignableFrom(DeviceFindController.class)) {
            return Optional.of(new DeviceSortView());
        }
        if (clazz.isAssignableFrom(UserActivityFindController.class)) {
            return Optional.of(new UserActivitySortView());
        }
        return Optional.empty();
    }

    /**
     * Function identify type Entity to sort
     *
     * @param clazz
     * @param entityList
     * @param <T>
     * @return
     */
    public <T> void sortFunc(Class clazz, Stream<T> entityList) {
        utils.printLine("Press s to make sort or press Enter to back in Main menu");
        String str = utils.readLine();
        if ("".equals(str)) {
            Main.getMainMenuView().baseMenu();
        }
        if ("s".equals(str)) {
            Optional<SortView> sortView = sortClass.getSortView(clazz);
            if (sortView.isPresent()) {
                sortView.get().sort(entityList);
            }
        }
    }
}
