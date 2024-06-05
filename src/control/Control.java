package control;

import java.io.*;

public class Control {

    public static void printMenu() {
        System.out.println("Добро пожаловать в консольный ежедневник" +
                "\n Максима Анатольевича," +
                "\nне дай бог им пользоваться в реальности =)" +
                "\n\nВведите цифру необходимого пункта:");

        int choose = inputData();

        switch (choose) {
            case 1:
                System.out.println("Добавить задачу в ежедневник");
            case 2:
                System.out.println("Получить задачи на день");
            case 3:
                System.out.println("Удалить задачу по id");
        }
    }

    private static int inputData()  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
           return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
