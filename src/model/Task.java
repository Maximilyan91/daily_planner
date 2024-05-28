package model;

import java.time.LocalDateTime;

public abstract class Task {

    private final int id;

    private String name;

    private String description;

    private Type type;

    private final LocalDateTime dateTime;

    private static int idGenerator = 0;

    public Task(String name, String description, Type type) {
        this.id = idGenerator;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;

        return id == task.id && name.equals(task.name) && description.equals(task.description) && type == task.type && dateTime.equals(task.dateTime);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }
}
