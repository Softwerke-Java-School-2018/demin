package com.miros.testproject.controller.activity;

import com.miros.testproject.controller.BaseController;
import com.miros.testproject.controller.sort.SortClass;
import com.miros.testproject.controller.sort.useractivity.UserActivityDateComparator;
import com.miros.testproject.controller.sort.useractivity.UserActivityNameComparator;
import com.miros.testproject.data.entity.UserActivity;

import java.util.stream.Stream;

/**
 * Controller for sort UserActivity elements
 */
public class UserActivitySortController extends BaseController {
    private SortClass sortClass = SortClass.getInstance();

    public void sortDate(Stream<UserActivity> userActivityStream) {
        userActivityStream = userActivityStream.sorted(new UserActivityDateComparator());
        userActivityStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserActivityFindController.class, userActivityStream);
    }

    public void sortUserName(Stream<UserActivity> userActivityStream) {
        userActivityStream = userActivityStream.sorted(new UserActivityNameComparator());
        userActivityStream
                .forEach(s -> utils.printLine(s));
        sortClass.sortFunc(UserActivityFindController.class, userActivityStream);
    }
}
