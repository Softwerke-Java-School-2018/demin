package com.miros.testproject.view.user;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.user.UserFindController;

public class UserFindView {
    private UserFindController userFindController = UserFindController.getInstance();

    private final String USER_FIND_VIEW="Choose which parameter will be searched\n" +
            "1 - id\n" +
            "2 - Name\n" +
            "3 - Birthday\n" +
            "4 - Show all users";
    /**
     * Модуль поиска пользователей
     */
    public void userFinder(){
        Utils.printLine(USER_FIND_VIEW);
        String num = Utils.readLine();
        switch (num) {
            case "1":
                Utils.printLine("Enter id");
                Integer id = Integer.parseInt(Utils.readLine());
                Utils.printLine(userFindController.idFind(id));
            case "2":
                Utils.printLine("Enter Name");
                String name = Utils.readLine();
                userFindController.nameFind(name);
            case "3":
                Utils.printLine("Enter BirthDay like dd/MM/yyyy");
                String birthDay = Utils.readLine();
                userFindController.dateFind(birthDay);
            case "4":
                userFindController.showAll();
        }
    }
}
