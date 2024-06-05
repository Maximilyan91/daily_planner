package model.impl;

import model.Task;
import model.Type;

import java.time.LocalDateTime;

public class MonthlyTask extends Task {

    public MonthlyTask(String name, String description, Type type) {
        super(name, description, type);
    }

    @Override
    public LocalDateTime nextDateTask() {
        return getDateTime().plusMonths(1);

    }
}
