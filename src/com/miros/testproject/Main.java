package com.miros.testproject;

import com.miros.testproject.data.DataCreator;
import com.miros.testproject.view.MainView;


public class Main {
    public static void main(String[] args) {
        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();

        MainView mainView = new MainView();
        mainView.baseMenu();
    }
}
