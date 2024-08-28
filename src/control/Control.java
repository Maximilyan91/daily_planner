package control;

import exception.IncorrectArgumentException;
import model.Task;
import model.Type;
import model.impl.*;
import service.TaskService;

import java.util.Scanner;

public class Control {

    private static final TaskService service = new TaskService();

    public static void controlPanel() {
        boolean appIsLauch = true;
        while (appIsLauch) {
            printMainMenu();
            int choice = readIntConsole();
            switch (choice) {
                case 1 -> System.out.println("Задача создана: \n" + createTask());
                case 2 -> System.out.println("Получить задачи на день");
                case 3 -> System.out.println("Удалить задачу по id");
                case 0 -> appIsLauch = false;
            }
        }
    }

    public static void printHeader() {
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

                3. Удалить задачу.\
                
                0. Выход из программы. \
                """);
    }

    private static String readStringConsole() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int readIntConsole() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            return sc.nextInt();
        } else {
            return -1;
        }
    }

    private static String createTask() {
        System.out.println("Введите название задачи");
        String name = readStringConsole();

        System.out.println("Введите описание задачи");
        String description = readStringConsole();

        System.out.println("Укажите тип задачи: 1 - личная, 2 - рабочая");

        Type type = setTypeTask();

        System.out.println("""
                И последнее:\
                
                1 - однократная задача.\
                
                2 - ежедневная задача.\
                
                3 - еженедельная задача.\
                
                4 - ежемесячная задача.\
                
                5 - ежегодная задача.\
                """);
        try {
            switch (readIntConsole()) {
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
        } catch (IncorrectArgumentException e) {
            System.out.println("Задача не создана. Введен неправильный аргумент имени или описания задачи.");
            controlPanel();
        }
        return service.getLastTask().toString();
    }

    private static Type setTypeTask() {
        int typeTask = readIntConsole();

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
                    typeTask = readIntConsole();
                }
            }
        } while (inCorrectInput);
        return type;
    }
}
