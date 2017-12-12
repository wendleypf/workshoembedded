package com.embedded.workshop.controller;

import com.embedded.workshop.model.Task;
import com.embedded.workshop.repository.TaskRepository;
import com.embedded.workshop.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TaskControllerImpl extends GenericController<Task, TaskRepository> {

    @Autowired
    public TaskControllerImpl(TaskServiceImpl service) {
        super(service);
    }
}
