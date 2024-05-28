package model.impl;

import model.Task;
import model.Type;

public class OneTimeTask extends Task {

    public OneTimeTask(String name, String description, Type type) {
        super(name, description, type);
    }
}
