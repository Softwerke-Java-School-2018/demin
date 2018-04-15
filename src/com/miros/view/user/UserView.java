package com.miros.view.user;

import com.miros.Utils;
import com.miros.controller.user.UserController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserView {

    // private UserController userController = new UserController();

    private static final String USER_VIEW="Enter the command number:\n" +
            "1 - user create\n" +
            "2 - user remove\n" +
            "3 - user update\n";

    public void userMenu() {
        Utils.printLine(USER_VIEW);
        String command = readLine();
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

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    /**
     * Создание пользователя и вызов контроллера
     */
    private void createReader(){
        Utils.printLine("Enter Name");
        String name = readLine();

        Utils.printLine("Enter Surname");
        String surname = readLine();

        Utils.printLine("Enter Patronymic");
        String patronymic = readLine();

        System.out.println("Enter BirthDay like 04/10/1983");
        String birthDay = readLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDay, formatter);
        UserController.getInstance().create(name, surname, patronymic, localDate);
    }
    /**
     * Удаление пользователя и вызов контроллера
     */

    private void deleteReader(){
        System.out.println("Enter Id");
        Integer id = Integer.parseInt(readLine());
        UserController.getInstance().delete(id);
    }
    /**
     * Обновление пользователя и вызов контроллера
     */

    private void updateReader(){
        Utils.printLine("Enter id element to update");
        Integer id = Integer.parseInt(readLine());
        Utils.printLine("Enter a Name for the change or leave it empty to leave as is");
        String name = readLine();
        Utils.printLine("Enter a Surname for the change or leave it empty to leave as is");
        String surname = readLine();
        Utils.printLine("Enter a Patronymic for the change or leave it empty to leave as is");
        String patronymic = readLine();

        Utils.printLine("Enter BirthDay like 04/10/1983 for the change or leave it empty to leave as is");
        String birthDay = readLine();

        UserController.getInstance().update(id, name, surname, patronymic, birthDay);
    }
}






