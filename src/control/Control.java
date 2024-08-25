package control;

import model.Task;
import model.Type;
import model.impl.*;
import service.TaskService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Control {

    private static final TaskService service = new TaskService();

    public static void controlPanel() {


        printHeader();
        while (true) {
            printMainMenu();
            int choice = Integer.parseInt(readConsole());
            switch (choice) {
                case 1:
                    System.out.println("Задача создана: \n" + createTask());
                    break;
                case 2:
                    System.out.println("Получить задачи на день");
                    break;
                case 3:
                    System.out.println("Удалить задачу по id");
                    break;
            }

        }
    }

    private static void printHeader() {
        System.out.println("""
                Добро пожаловать в консольный ежедневник\

                Максима Анатольевича,\

                не дай бог им пользоваться в реальности =)\

                """);
    }

    private static void printMainMenu() {
        System.out.println("""
                Введите цифру необходимого пункта меню:\

                1. Добавить задачу.\

                2. Получить задачи на день.\

                3. Удалить задачу.""");
    }

    private static String readConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createTask() {
        System.out.println("Введите название задачи");
        String name = readConsole();

        System.out.println("Введите описание задачи");
        String description = readConsole();

        System.out.println("Укажите тип задачи: 1 - личная, 2 - рабочая");

        Type type = setTypeTask();

        // TODO: вывести повторяемость в отдельный метод, проработать все ситуации с неправильным вводом

        System.out.println("""
                И последнее:\
                                
                1 - однократная задача.\
                                
                2 - ежедневная задача.\
                               
                3 - еженедельная задача.\
                                
                4 - ежемесячная задача.\
                               
                5 - ежегодная задача.\
                """);
        int repeatability = Integer.parseInt(readConsole());
        switch (repeatability) {
            case 1 -> {
                Task task = new OneTimeTask(name, description, type);
                return task.toString();
            }
            case 2 -> {
                Task task = new DailyTask(name, description, type);
                return task.toString();
            }
            case 3 -> {
                Task task = new WeeklyTask(name, description, type);
                return task.toString();
            }
            case 4 -> {
                Task task = new MonthlyTask(name, description, type);
                return task.toString();
            }
            case 5 -> {
                Task task = new YearlyTask(name, description, type);
                return task.toString();
            }
        }
        return service.getLastTask().toString();
    }

    private static Type setTypeTask() {
        int typeTask = Integer.parseInt(readConsole());

        boolean inCorrectInput;
        Type type = null;
        do {
            switch (typeTask) {
                case 1 -> {
                    type = Type.PERSONAL;
                    inCorrectInput = false;
                }
                case 2 -> {
                    type = Type.WORK;
                    inCorrectInput = false;
                }
                default -> {
                    System.out.println("Укажите только цифру 1 или 2");
                    inCorrectInput = true;
                    typeTask = Integer.parseInt(readConsole());
                }
            }
        } while (inCorrectInput);
        return type;
    }
}
