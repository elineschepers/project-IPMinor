package com.example.taskmanager.model.service;

import com.example.taskmanager.model.Subtask;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.SubTaskDTO;
import com.example.taskmanager.model.dto.TaskDTO;
import com.example.taskmanager.model.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImplementation implements TaskService {

    private final TaskRepository repository;
    private final ConverterService converterService;


    @Autowired
    public TaskServiceImplementation(TaskRepository repository, ConverterService converterService) {

        this.repository=repository;
        this.converterService = converterService;
    }


    @Override
    public List<TaskDTO> getTasks() {

        return repository.findAll().stream().map(t ->
        {
            return converterService.convertToDto(t);

        }).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO task) {

        //ArrayList<String> errors = new ArrayList<>();
            Task task1 = new Task();
            task1.setDescription(task.getDescription());
            task1.setName(task.getName());
            task1.setTime(task.getTime());
            repository.save(task1);

    }

    private ArrayList<String> setdescription(ArrayList<String> errors,Task t, String description)
    {
        if(description.trim().isEmpty())
        {
            errors.add("descriptie mag niet leeg zijn");
        }
        else {
            t.setDescription(description);
        }
        return errors;
    }
    private ArrayList<String> setname(ArrayList<String> errors,Task t, String name)
    {
        if(name.trim().isEmpty())
        {
            errors.add("naam mag niet leeg zijn");
        }
        else {
            t.setDescription(name);
        }
        return errors;
    }
    @Override
    public TaskDTO addTaskWithReturn(TaskDTO taskDTO) {
        addTask(taskDTO);
        return taskDTO;
    }

    @Override
    public TaskDTO getTask(int id) {
        System.out.println(id);
        System.out.println(repository.findById(id).get().getId());
        return converterService.convertToDto(repository.findById(id).orElseThrow(()-> new IllegalArgumentException("id bestaat niet")));
    }

    @Override
    public SubTaskDTO addSubTask(int taskId, SubTaskDTO subTaskDTO) {

        Task task = repository.findById(taskId).orElseThrow(()-> new IllegalArgumentException("id bestaat niet"));
        Subtask subtask= new Subtask();
        subtask.setDescription(subTaskDTO.getDescription());
        subtask.setNaam(subTaskDTO.getName());
        task.addSubtask(subtask);
        repository.save(task);
        return converterService.convertToDto(subtask);
    }
}
