package model.impl;

import model.Task;
import model.Type;

import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String name, String description, Type type) {
        super(name, description, type);
    }

    @Override
    public LocalDateTime nextDateTask() {
        return getDateTime().plusDays(1);
    }
}
