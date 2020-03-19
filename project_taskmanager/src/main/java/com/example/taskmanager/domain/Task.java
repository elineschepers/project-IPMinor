package com.example.taskmanager.domain;



import com.example.taskmanager.dto.TaskDTO;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private String name;
    ArrayList<TaskDTO> tasks;
    @NotEmpty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime time;

    public Task()
    {
        tasks=new ArrayList<>();

    }

    public Task(String name, String description, LocalDateTime time) {
        //System.out.println(time);
        tasks=new ArrayList<>();
        setName(name);
        setTime(time);

        setDescription(description);

    }
public ArrayList<TaskDTO> getTasks(){return tasks;}
    public int getAmountOfSubs(){return tasks.size();}

    public void addSubtask(TaskDTO task)
    {
        tasks.add(task);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


}
