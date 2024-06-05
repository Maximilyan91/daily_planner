package service;

import exception.TaskNotFoundException;
import model.Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {

    private static final Map<Integer, Task> allTasks = new HashMap<>();
    private static final List<Task> removedTasks = new ArrayList<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new TaskNotFoundException("Добавляемая задача равна null");
        }

        if (!allTasks.containsValue(task)) {
            allTasks.put(task.getId(), task);
        }
    }

    public Task updateDescription(int id, String description) {
        Task updatedTask = allTasks.get(id);

        if (updatedTask == null) {
            throw new TaskNotFoundException("Задачи с таким идентификатором не существует");
        }
        updatedTask.setDescription(description);
        return updatedTask;
    }

    public Task removeTaskById(int id) {
        Task removedTask = allTasks.remove(id);

        if (removedTask == null) {
            throw new TaskNotFoundException("Задачи с таким идентификатором не существует");
        }
        removedTasks.add(removedTask);
        return removedTask;
    }

    public List<Task> getRemovedTasks() {
        if (removedTasks.isEmpty()) {
            throw new TaskNotFoundException("удаленные задачи отсутствуют");
        }
        return removedTasks;
    }

    public Map<Integer, Task> getAllTasks() {
        return allTasks;
    }

    public List<Task> getAllByDate(LocalDate date) {
      return allTasks.values()
                .stream()
                .filter(task -> task.nextDateTask()
                        .toLocalDate()
                        .equals(date))
              .collect(Collectors.toList());
    }
}
