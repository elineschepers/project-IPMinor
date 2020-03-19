package com.example.taskmanager.service;

import com.example.taskmanager.domain.Task;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImplementation implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceImplementation(TaskRepository repository) {

        this.repository=repository;
    }


    @Override
    public List<TaskDTO> getTasks() {

        return repository.findAll().stream().map(t ->
        {
            TaskDTO dto = new TaskDTO();
            dto.setDescription(t.getDescription());
            dto.setName(t.getName());
            dto.setTasks(t.getTasks());
            dto.setTime(t.getTime());
            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO task) {

        Task task1 = new Task();
        task1.setDescription(task.getDescription());
        task1.setName(task.getName());
        task1.setTime(task.getTime());
        repository.save(task1);
    }

    @Override
    public TaskDTO getTask(int id) {
        return getTasks().get(id);
    }
}
