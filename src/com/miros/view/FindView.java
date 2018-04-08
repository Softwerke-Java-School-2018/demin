package com.miros.view;

import java.util.Scanner;

public class FindView {
    public void findMenu() {
            System.out.println("Введите номер команды:" +
            "1 - поиск устройств" +
            "2 - поиск пользователей" +
            "3 - поиск истории покупок");

            String command = readLine();
            switch (command) {
                case "1":
                    deviceFinder();
                case "2":
                    userFinder();
                case "3":
                    userActivityFinder();
            }
    }

    public String readLine() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    private void deviceFinder(){
        System.out.println("Выберите по какому параметру будет производиться поиск" +
                "1 - id" +
                "2 - Type" +
                "3 - Color");
        Integer num = Integer.parseInt(readLine());
    }

    private void userFinder(){
    }

    private void userActivityFinder(){
    }
}
