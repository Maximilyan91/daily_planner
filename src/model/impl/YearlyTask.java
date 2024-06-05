package model.impl;

import model.Task;
import model.Type;

import java.time.LocalDateTime;

public class YearlyTask extends Task {

    public YearlyTask(String name, String description, Type type) {
        super(name, description, type);
    }

    @Override
    public LocalDateTime nextDateTask() {
        return getDateTime().plusYears(1);
    }
}