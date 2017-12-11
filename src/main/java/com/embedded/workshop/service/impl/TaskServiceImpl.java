package com.embedded.workshop.service.impl;

import com.embedded.workshop.model.Task;
import com.embedded.workshop.repository.TaskRepository;
import com.embedded.workshop.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task, TaskRepository> {
}
