package com.embedded.workshop.model;

import com.embedded.workshop.model.enums.Priority;
import com.embedded.workshop.model.enums.State;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "tb_task")
@Entity(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "")
    @NotEmpty(message = "")
    @NotBlank(message = "")
    @Size(min = 5, max = 100, message = "O nome da task deve ter entre 5 e 100 caracteres")
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    public Task() {
        this.state = State.TODO;
    }

    public Task(String name, Priority priority) {
        this.name = name;
        this.priority = priority;
        this.state = State.TODO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
