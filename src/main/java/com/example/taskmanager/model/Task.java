package com.example.taskmanager.model;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    private String description;
    @NotEmpty
    private String name;
    @OneToMany(cascade= CascadeType.ALL)
    private List<Subtask> subTasks;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime time;

    public Task()
    {
        subTasks =new ArrayList<>();

    }

    public Task(String name, String description, LocalDateTime time) {
        //System.out.println(time);
        subTasks =new ArrayList<>();
        setName(name);
        setTime(time);

        System.out.println(id);
        setDescription(description);

    }
public List<Subtask> getSubTasks(){return subTasks;}
    public int getAmountOfSubs(){return subTasks.size();}

    public void addSubtask(Subtask task)
    {
        subTasks.add(task);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description==null || description.isEmpty()){throw new IllegalArgumentException("description mag niet leeg zijn!");}
        else {
            this.description = description;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        if(id==null){throw new IllegalArgumentException("er is geen id meegegeven!");}
        else {
            this.id = id;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()||name==null){throw new IllegalArgumentException("naam kan niet leeg zijn!");}
        else {
            this.name = name;
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        if(time.isBefore(LocalDateTime.now()))
        {
            throw new IllegalArgumentException("tijd kan niet in het verleden liggen");
        }
        if(time==null){throw new IllegalArgumentException("tijd kan niet leeg zijn!");}
        else {
            this.time = time;
        }
    }


}
