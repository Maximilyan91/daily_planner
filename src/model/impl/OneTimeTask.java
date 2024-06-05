package model.impl;

import model.Task;
import model.Type;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {

    public OneTimeTask(String name, String description, Type type) {
        super(name, description, type);
    }

    @Override
    public LocalDateTime nextDateTask() {
        return getDateTime();
    }
}
