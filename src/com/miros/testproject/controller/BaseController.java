package com.miros.testproject.controller;

import com.miros.testproject.Utils;
import com.miros.testproject.data.DAO.DeviceDAO;
import com.miros.testproject.data.DAO.UserActivityDAO;
import com.miros.testproject.data.DAO.UserDAO;
import com.miros.testproject.view.MainView;

public class BaseController {

    private static MainView mainView = new MainView();
    private final Utils utils = new Utils();

    public BaseController() {
    }

    protected MainView getBaseView() {
        return mainView;
    }

    public void waitForEnter() {
        while(true) {
            Utils.printLine("Press Enter to back in main menu");
            String str = utils.scanner().nextLine();
            if(str.equals("")){
                mainView.baseMenu();
            }
            else {
                Utils.printLine("It's wrong, try again");
            }
        }
    }
}





















