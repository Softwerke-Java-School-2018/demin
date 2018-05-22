package com.miros.testproject.view.user;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.user.UserController;
import com.miros.testproject.view.BaseView;


/**
 *  This class creates a menu for Create, Delete, Update
 *  some user and redirect on user Controller
 */
public class UserView extends BaseView {
    private UserController userController =  (UserController) ControllersFabric.getController(UserController.class).get();
    private static final String USER_VIEW = "Enter the command number:\n" +
            "1 - user create\n" +
            "2 - user remove\n" +
            "3 - user update\n";
    public void userMenu() {
        utils.printLine(USER_VIEW);
        String command = utils.readLine();
        switch (command) {
            case "1":
                createReader();
                return;
            case "2":
                deleteReader();
                return;
            case "3":
                updateReader();
                return;
            default:
                return;
        }
    }
    private void createReader() {
        utils.printLine("Enter Name");
        String name = utils.readLine();
        utils.printLine("Enter Surname");
        String surname = utils.readLine();
        utils.printLine("Enter Patronymic");
        String patronymic = utils.readLine();
        System.out.println("Enter BirthDay like 04/10/1983");
        String birthDay = utils.readLine();
        userController.create(name, surname, patronymic, birthDay);
    }
    private void deleteReader() {
        System.out.println("Enter Id");
        Integer id = Integer.parseInt(utils.readLine());
        userController.delete(id);
    }
    private void updateReader() {
        utils.printLine("Enter id element to update");
        Integer id = Integer.parseInt(utils.readLine());
        utils.printLine("Enter a Name for the change or leave it empty to leave as is");
        String name = utils.readLine();
        utils.printLine("Enter a Surname for the change or leave it empty to leave as is");
        String surname = utils.readLine();
        utils.printLine("Enter a Patronymic for the change or leave it empty to leave as is");
        String patronymic = utils.readLine();
        utils.printLine("Enter BirthDay like 04/10/1983 for the change or leave it empty to leave as is");
        String birthDay = utils.readLine();
        userController.update(id, name, surname, patronymic, birthDay);
    }
}






