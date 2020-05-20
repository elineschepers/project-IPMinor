package com.example.taskmanager;

import com.example.taskmanager.model.dto.SubTaskDTO;
import com.example.taskmanager.model.dto.TaskDTO;
import com.example.taskmanager.model.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@Transactional
public class TaskServiceTest {

    @Autowired
    private TaskService service;


    @Test
    public void testGetTasks()
    {
        TaskDTO taskDTO=new TaskDTO();
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        taskDTO.setName("don't forget birthday");
        taskDTO.setTime(LocalDateTime.of(2020,11,24,10,0));
        taskDTO.setDescription("test");
        service.addTask(taskDTO);

        List<TaskDTO> tasks= service.getTasks();

        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1,tasks.size());
        TaskDTO task=tasks.get(0);
        assertEquals(1,tasks.size());
        assertNotNull(service.addTaskWithReturn(taskDTO));
        assertNotNull(service.getTask(task.getId()));

        assertNotNull(service.getTasks());
        assertNotNull(service.addSubTask(task.getId(),subTaskDTO));
        assertNotNull(task);
        assertNotNull(subTaskDTO);
    }


}
