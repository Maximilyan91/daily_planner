package model.impl;

import model.Task;
import model.Type;

import java.time.LocalDateTime;

public class WeeklyTask extends Task {

    public WeeklyTask(String name, String description, Type type) {
        super(name, description, type);
    }

    public LocalDateTime nextDateTask() {
        return getDateTime().plusWeeks(1);
    }
}
