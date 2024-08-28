package control;

import exception.IncorrectArgumentException;
import model.Task;
import model.Type;
import model.impl.*;
import service.TaskService;

import java.util.Scanner;

public class Control {

    private static final TaskService service = new TaskService();

    public static void appMainMenu() {
        boolean appIsLaunch = true;
        while (appIsLaunch) {
            printMainMenu();
            int choice = readIntConsole();
            switch (choice) {
                case 1 -> {
                    Task task = createTask();
                    if (task != null) {
                        System.out.println("Задача создана " + task);
                    }
                }
                case 2 -> System.out.println("Получить задачи на день");
                case 3 -> System.out.println("Удалить задачу по id");
                case 0 -> appIsLaunch = false;
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

    private static Task createTask() {
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
        return taskInitialize(name, description, type);
    }

    private static Type setTypeTask() {
        int typeTask = readIntConsole();

        boolean isInCorrectInput;
        Type type = null;
        do {
            switch (typeTask) {
                case 1 -> {
                    type = Type.PERSONAL;
                    isInCorrectInput = false;
                }
                case 2 -> {
                    type = Type.WORK;
                    isInCorrectInput = false;
                }
                default -> {
                    System.out.println("Укажите только цифру 1 или 2");
                    isInCorrectInput = true;
                    typeTask = readIntConsole();
                }
            }
        } while (isInCorrectInput);
        return type;
    }

    private static Task taskInitialize(String name, String description, Type type) {
        int choice = -1;
        Task task = null;
        while (choice > 5 || choice < 0) {
            choice = readIntConsole();
            try {
                switch (choice) {
                    case 1 -> task = new OneTimeTask(name, description, type);
                    case 2 -> task = new DailyTask(name, description, type);
                    case 3 -> task = new WeeklyTask(name, description, type);
                    case 4 -> task = new MonthlyTask(name, description, type);
                    case 5 -> task = new YearlyTask(name, description, type);
                    default -> System.out.println("Введите число от 1 до 5");
                }
            } catch (IncorrectArgumentException e) {
                System.out.println("==== Задача не создана!!! === \n Введён неправильный аргумент - " + e + " имени или описания задачи.\n");
                break;
            }
        }
        if (task != null) {
            service.addTask(task);
        }
        return task;
    }
}

