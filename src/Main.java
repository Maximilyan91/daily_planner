import model.Task;
import model.Type;
import model.impl.*;

public class Main {
    public static void main(String[] args) {

        Task testingTask1 = new OneTimeTask("Одноразовая задача №1", "Какое-то описание", Type.PERSONAL);
        Task testingTask2 = new DailyTask("Ежедневная задача №2", "Какое-то описание", Type.WORK);
        Task testingTask3 = new WeeklyTask("Еженедельная задача №3", "Какое-то описание", Type.PERSONAL);
        Task testingTask4 = new MonthlyTask("Ежемесячная задача №4", "Какое-то описание", Type.WORK);
        Task testingTask5 = new YearlyTask("Ежегодная задача №5", "Какое-то описание", Type.PERSONAL);

        //   Task invalidTask1 = new YearlyTask("", "Какое-то описание", Type.PERSONAL);
        //   Task invalidTask2 = new YearlyTask("Ежегодная задача №5", "", Type.PERSONAL);

        Task[] tasks = {testingTask1, testingTask2, testingTask3, testingTask4, testingTask5};
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}