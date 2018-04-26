package com.miros.testproject;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.view.MainView;

public class Main {
    private static MainView mainView = new MainView();
    public static void main(String[] args) {
        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
        mainView.baseMenu();
    }
    public static MainView getMainView() {
        return mainView;
    }
}
