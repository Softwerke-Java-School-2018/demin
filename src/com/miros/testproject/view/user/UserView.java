package com.miros.testproject.view.user;

import com.miros.testproject.Utils;
import com.miros.testproject.controller.user.UserController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserView {

    // private UserController userController = new UserController();

    private static final String USER_VIEW="Enter the command number:\n" +
            "1 - user create\n" +
            "2 - user remove\n" +
            "3 - user update\n";

    public void userMenu() {
        Utils.printLine(USER_VIEW);
        String command = Utils.readLine();
        switch (command) {
            case "1":
                createReader();
            case "2":
                deleteReader();
            case "3":
                updateReader();
        }
    }

    public UserView() {
    }

    private void createReader(){
        Utils.printLine("Enter Name");
        String name = Utils.readLine();

        Utils.printLine("Enter Surname");
        String surname = Utils.readLine();

        Utils.printLine("Enter Patronymic");
        String patronymic = Utils.readLine();

        System.out.println("Enter BirthDay like 04/10/1983");
        String birthDay = Utils.readLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDay, formatter);
        UserController.getInstance().create(name, surname, patronymic, localDate);
    }

    private void deleteReader(){
        System.out.println("Enter Id");
        Integer id = Integer.parseInt(Utils.readLine());
        UserController.getInstance().delete(id);
    }


    private void updateReader(){
        Utils.printLine("Enter id element to update");
        Integer id = Integer.parseInt(Utils.readLine());
        Utils.printLine("Enter a Name for the change or leave it empty to leave as is");
        String name = Utils.readLine();
        Utils.printLine("Enter a Surname for the change or leave it empty to leave as is");
        String surname = Utils.readLine();
        Utils.printLine("Enter a Patronymic for the change or leave it empty to leave as is");
        String patronymic = Utils.readLine();

        Utils.printLine("Enter BirthDay like 04/10/1983 for the change or leave it empty to leave as is");
        String birthDay = Utils.readLine();

        UserController.getInstance().update(id, name, surname, patronymic, birthDay);
    }
}






