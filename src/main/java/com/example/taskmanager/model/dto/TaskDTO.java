package com.example.taskmanager.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {




    private Integer id;
    @NotEmpty
    private String description;
    @NotEmpty
    private String name;
    List<SubTaskDTO> subTasks ;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime time;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubTaskDTO> getTasks() {
        return subTasks;
    }

    public void setTasks(List<SubTaskDTO> tasks) {

       this.subTasks=tasks;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getAmountOfSubs(){return subTasks.size();}

    public void addSubTask(SubTaskDTO task)
    {
        if(subTasks == null)
        {
            subTasks = new ArrayList<>();
        }
        subTasks.add(task);
    }
}
