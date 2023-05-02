package com.teamvoid.gocircle.Todo;

import java.time.LocalDate;

public class LocalEvent {
    private String description;
    private LocalDate date;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalEvent(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return "At:      " + this.getDate() + "      " + this.getDescription();
    }
}
