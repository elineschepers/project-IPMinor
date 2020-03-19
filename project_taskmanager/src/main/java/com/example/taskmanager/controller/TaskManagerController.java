package com.example.taskmanager.controller;

import com.example.taskmanager.domain.Task;
import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.TaskServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addTask(@ModelAttribute TaskDTO task)
    {

        service.addTask(task);
        return "redirect:/task";
    }
    @RequestMapping("/task/change/{id}")
    public String changeTask(@PathVariable("id") int id,Model model)
    {

        model.addAttribute("task", service.getTask(id));
        changeTask=id;
        return "changeTask";

    }

    @PostMapping("/task/edit")
    public String edit(Task task)
    {
        service.getTask(changeTask).setDescription(task.getDescription());
        service.getTask(changeTask).setName(task.getName());
        service.getTask(changeTask).setTime(task.getTime());

        return "redirect:/task";
    }
    @RequestMapping("/task/{id}/sub/create")
    public String subtask(@PathVariable("id") int id,Model model)
    {
        Task sub = new Task();
        //taskDB.getTask(id).addSubtask(sub);
        model.addAttribute("subtask",sub);
        model.addAttribute("taskId",id);
        tempIdForSub=id;
        return "addSubtask";
    }
    @RequestMapping("/task/newSubtask/{id}")
    public String subAdded(@PathVariable("id") int id,TaskDTO subTask,Model model)
    {

        service.getTask(id).addSubTask(subTask);

        return "redirect:/task/"+id;
    }


}
