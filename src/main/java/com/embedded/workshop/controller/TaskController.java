package com.embedded.workshop.controller;

import com.embedded.workshop.exception.EventException;
import com.embedded.workshop.model.Task;
import com.embedded.workshop.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController implements CrudController<Task> {
    private TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    @Override
    public ResponseEntity<Task> create(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.create(task), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Task> update(@PathVariable("id") Integer id, @RequestBody Task task) throws EventException {
        Task updateTask = taskService.getById(id);
        if(updateTask == null){
            throw new EventException("Task não encontrada.",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(taskService.update(task), HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        taskService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Task>> all() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    @Override
    public ResponseEntity<Task> getById(@PathVariable("id") Integer id) throws EventException {
        Task task = taskService.getById(id);
        if(task == null){
            throw new EventException("Task não encontrada.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
}
