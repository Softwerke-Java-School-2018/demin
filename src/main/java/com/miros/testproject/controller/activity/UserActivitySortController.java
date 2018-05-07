package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseClassController;
import com.miros.testproject.controller.sort.useractivity.UserActivityDateComparator;
import com.miros.testproject.controller.sort.useractivity.UserActivityNameComparator;
import com.miros.testproject.data.entity.UserActivity;

import java.util.Collections;
import java.util.List;

public class UserActivitySortController extends BaseClassController {
    private List<UserActivity> tempUserActivityDAO = tempDataService.getTempDAOUserActivityList();

    public void sortByDate() {
        comparator = new UserActivityDateComparator();
        Collections.sort(tempUserActivityDAO, comparator);
        tempUserActivityDAO
                .forEach(s -> utils.printLine(s));
        utils.sortFunc(userActivityFindController);
    }

    public void sortByUserName() {
        comparator = new UserActivityNameComparator();
        Collections.sort(tempUserActivityDAO, comparator);
        tempUserActivityDAO
                .forEach(s -> utils.printLine(s));
        utils.sortFunc(userActivityFindController);
    }
}
