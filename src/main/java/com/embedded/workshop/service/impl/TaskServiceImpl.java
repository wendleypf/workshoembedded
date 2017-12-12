package com.embedded.workshop.service.impl;

import com.embedded.workshop.model.Task;
import com.embedded.workshop.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends GenericServiceImpl<Task, TaskRepository> {
}
