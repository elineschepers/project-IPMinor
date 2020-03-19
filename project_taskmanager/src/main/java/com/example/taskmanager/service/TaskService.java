package com.example.taskmanager.service;

import com.example.taskmanager.domain.Task;
import com.example.taskmanager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    void addTask (TaskDTO task);

    TaskDTO getTask(int id);
}
