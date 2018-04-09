package com.miros.view;

import com.miros.controller.UserController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserView {

   // private UserController userController = new UserController();

    public void userMenu() {
        System.out.println("Enter the command number:\n" +
                "1 - user create\n" +
                "2 - user remove\n" +
                "3 - user update\n");
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
        System.out.println("Enter Name");
        String name = readLine();

        System.out.println("Enter Surname");
        String surname = readLine();

        System.out.println("Enter Patronymic");
        String patronymic = readLine();

        System.out.println("Enter BirthDay like 04/10/1983");
        String birthDay = readLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDay, formatter);
        new UserController().create(name, surname, patronymic, localDate);
    }

    /**
     * Удаление пользователя и вызов контроллера
     */

    private void deleteReader(){
        System.out.println("Enter Id");
        Integer id = Integer.parseInt(readLine());
        new UserController().delete(id);
    }

    /**
     * Обновление пользователя и вызов контроллера
     */

    private void updateReader(){
        System.out.println("Enter id element to update");
        Integer id = Integer.parseInt(readLine());
        System.out.println("Enter a Name for the change or leave it empty to leave as is");
        String name = readLine();
        System.out.println("Enter a Surname for the change or leave it empty to leave as is");
        String surname = readLine();
        System.out.println("Enter a Patronymic for the change or leave it empty to leave as is");
        String patronymic = readLine();

        System.out.println("Enter BirthDay like 04/10/1983 for the change or leave it empty to leave as is");
        String birthDay = readLine();

        new UserController().update(id, name, surname, patronymic, birthDay);

    }
}






