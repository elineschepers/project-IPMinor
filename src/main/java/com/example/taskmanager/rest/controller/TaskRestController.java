package com.example.taskmanager.rest.controller;


import com.example.taskmanager.model.dto.TaskDTO;
import com.example.taskmanager.model.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {
    private final TaskService service;

    public TaskRestController(TaskService service)
    {
        this.service=service;
    }

    @GetMapping("/task")
    public List<TaskDTO> getTasks()
    {
        return service.getTasks();
    }

    @PostMapping("/task")
    public TaskDTO createNewTask(@RequestBody @Valid TaskDTO taskDTO)
    {
        return service.addTaskWithReturn(taskDTO);
    }
}
