package com.miros.testproject.view.user;

import com.miros.testproject.controller.ControllersFabric;
import com.miros.testproject.controller.user.UserFindController;
import com.miros.testproject.view.BaseView;
import lombok.Data;

/**
 *  This class creates a menu to search
 *  for users and redirects it to the controller
 */
@Data
public class UserFindView extends BaseView {
    private UserFindController userFindController = (UserFindController) ControllersFabric.getController(UserFindController.class).get();
    private final String USER_FIND_VIEW="Choose which parameter will be searched\n" +
            "1 - id\n" +
            "2 - Name\n" +
            "3 - Birthday\n" +
            "4 - Show all users";

    public void userFinder(){
        utils.printLine(USER_FIND_VIEW);
        String num = utils.readLine();
        switch (num) {
            case "1":
                utils.printLine("Enter id");
                Integer id = Integer.parseInt(utils.readLine());
                userFindController.findId(id);
            case "2":
                utils.printLine("Enter Name");
                String name = utils.readLine();
                userFindController.findName(name);
            case "3":
                utils.printLine("Enter BirthDay like dd/MM/yyyy");
                String birthDay = utils.readLine();
                userFindController.findBirthDay(birthDay);
            case "4":
                userFindController.showAll();
            default:
                utils.printLine("It's Wrong");
                waitForEnter();
        }
    }
}
