import control.Control;

public class Main {
    public static void main(String[] args) {

//        Task testingTask1 = new OneTimeTask("Одноразовая задача №1", "Какое-то описание", Type.PERSONAL);
//        Task testingTask2 = new DailyTask("Ежедневная задача №2", "Какое-то описание", Type.WORK);
//        Task testingTask3 = new WeeklyTask("Еженедельная задача №3", "Какое-то описание", Type.PERSONAL);
//        Task testingTask4 = new MonthlyTask("Ежемесячная задача №4", "Какое-то описание", Type.WORK);
//        Task testingTask5 = new YearlyTask("Ежегодная задача №5", "Какое-то описание", Type.PERSONAL);
//
//        //   Task invalidTask1 = new YearlyTask("", "Какое-то описание", Type.PERSONAL);
//        //   Task invalidTask2 = new YearlyTask("Ежегодная задача №5", "", Type.PERSONAL);
//        TaskService service = new TaskService();
//
//        service.addTask(testingTask1);
//        service.addTask(testingTask2);
//        service.addTask(testingTask3);
//        service.addTask(testingTask4);
//        service.addTask(testingTask5);
//        LocalDate date =LocalDate.of(2024, 8, 5);

//        for (Task task : service.getAllTasks().values()) {
//            System.out.println(task);
//        }
//        System.out.println(service.getAllByDate(date));
        Control.printHeader();
        Control.appMainMenu();
    }
}