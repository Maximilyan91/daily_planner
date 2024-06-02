package model;

import exception.IncorrectArgumentException;
import validate.Validation;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {

    private static int idGenerator = 0;
    private final int id;
    private final LocalDateTime dateTime;
    private String name;
    private String description;
    private Type type;

    public Task(String name, String description, Type type) {
        this.id = idGenerator;
        setName(name);
        setDescription(description);
        this.type = type;
        this.dateTime = LocalDateTime.now();
        idGenerator++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validation.validateString(name)) {
            throw new IncorrectArgumentException(name);
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (!Validation.validateString(description)) {
            throw new IncorrectArgumentException(description);
        }
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return getId() == task.getId() && Objects.equals(getName(), task.getName()) && Objects.equals(getDescription(), task.getDescription()) && getType() == task.getType() && Objects.equals(getDateTime(), task.getDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getType(), getDateTime());
    }
}
