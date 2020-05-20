package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.SubTaskDTO;
import com.example.taskmanager.model.dto.TaskDTO;
import com.example.taskmanager.model.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TaskManagerController {

    private int tempIdForSub;
    private int changeTask;
    @Autowired
    TaskService service;
    @RequestMapping("/")
    public String navi()
    {
        return "navigation";
    }

    @RequestMapping("/task")
    public String getTasks(Model model)
    {
        model.addAttribute("tasks", service.getTasks());
        return "index";
    }

    @RequestMapping("/task/{id}")
    public String getInfo(@PathVariable("id") int id,Model model)
    {

        model.addAttribute("task", service.getTask(id));

        model.addAttribute("subtasks", service.getTask(id).getTasks());
        return "taskInfo";

    }
    @RequestMapping("/task/new")
    public String goToAdd(Model model)
    {

        model.addAttribute("task",new Task());
        return "newTask";
    }
    @PostMapping("/task/newTask")
    public String addTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            return "newTask";
        }else {
            service.addTask(task);
            return "redirect:/task";
        }
    }
    @RequestMapping("/task/change/{id}")
    public String changeTask(@PathVariable("id") int id,Model model)
    {

        model.addAttribute("task", service.getTask(id));
        changeTask=id;
        System.out.println(changeTask);
        return "changeTask";

    }

    @PostMapping("/task/edit")
    public String edit(@ModelAttribute @Valid  TaskDTO task)
    {
        System.out.println(changeTask);
        // todo hier is iets mis hij veranderd de description niet?
        service.getTask(changeTask).setDescription(task.getDescription());
        System.out.println(task.getDescription());
        System.out.println(service.getTask(changeTask).getDescription());
        service.getTask(changeTask).setName(task.getName());
        service.getTask(changeTask).setTime(task.getTime());

        return "redirect:/task";
    }
    @RequestMapping("/task/{id}/sub/create")
    public String subtask(@PathVariable("id") int id,Model model)
    {
        SubTaskDTO sub = new SubTaskDTO();
        //taskDB.getTask(id).addSubtask(sub);
        model.addAttribute("subtask",sub);
        model.addAttribute("taskId",id);
        tempIdForSub=id;
        return "addSubtask";
    }
    @RequestMapping("/task/newSubtask/{id}")
    public String subAdded(@PathVariable("id") int id,SubTaskDTO subTask,Model model)
    {

        service.addSubTask(id,subTask);

        return "redirect:/task/"+id;
    }


}
