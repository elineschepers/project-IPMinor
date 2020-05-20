package com.example.taskmanager.model.service;

import com.example.taskmanager.model.Subtask;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.SubTaskDTO;
import com.example.taskmanager.model.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ConverterService {

    public TaskDTO convertToDto(Task t)
    {
        TaskDTO dto = new TaskDTO();
        dto.setId(t.getId());
        dto.setDescription(t.getDescription());
        dto.setName(t.getName());
        dto.setTasks(t.getSubTasks().stream().map(this::convertToDto).collect(Collectors.toList()));
        dto.setTime(t.getTime());
        return dto;
    }

    public SubTaskDTO convertToDto(Subtask sub)
    {
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setDescription(sub.getDescription());
        subTaskDTO.setId(sub.getId());
        subTaskDTO.setName(sub.getNaam());
        return subTaskDTO;
    }

}
