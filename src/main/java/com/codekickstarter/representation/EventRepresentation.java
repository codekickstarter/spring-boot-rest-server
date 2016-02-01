package com.codekickstarter.representation;

import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

public class EventRepresentation {

    @NotBlank
    private String name;
    private LocalDate start;
    private LocalDate end;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
