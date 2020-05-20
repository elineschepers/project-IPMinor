package com.example.taskmanager.model.service;

import com.example.taskmanager.model.dto.SubTaskDTO;
import com.example.taskmanager.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    void addTask (TaskDTO task);

    TaskDTO addTaskWithReturn(TaskDTO taskDTO);

    TaskDTO getTask(int id);

    SubTaskDTO addSubTask(int taskId,SubTaskDTO subTaskDTO);
}
