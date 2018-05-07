package com.miros.testproject;

import com.miros.testproject.data.DataCreator;

import com.miros.testproject.view.MainMenuView;

public class Main {
    private static final MainMenuView mainMenuView = new MainMenuView();
    public static void main(String[] args) {
        DataCreator dataCreator = new DataCreator();
        dataCreator.dataAdd();
        mainMenuView.baseMenu();
    }
    public static MainMenuView getMainMenuView() {
        return mainMenuView;
    }
}
