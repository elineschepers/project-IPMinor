package com.example.taskmanager;

import com.example.taskmanager.model.dto.SubTaskDTO;
import com.example.taskmanager.model.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskDTOTest {

    private TaskDTO task = new TaskDTO();
    private SubTaskDTO sub=new SubTaskDTO();

    @Test
    public void testTaskDTO() {

        task.setName("don't forget birthday");
        task.setTime(LocalDateTime.of(2020, 11, 24, 10, 0));
        task.setDescription("don't forget your own birthday!");

        sub.setName("light candles");
        //sub.setTime(LocalDateTime.of(2020, 11, 24, 10, 0));
        sub.setDescription("don't forget to light the candles on the birthdaycake!");
        task.addSubTask(sub);


        assertNotNull(task.getTasks());
        assertFalse(task.getTasks().isEmpty());
        assertEquals(1,task.getTasks().size());
        assertNotNull(task.getTasks().get(0));
        assertNotNull(task.getDescription());
        assertNotNull(task.getName());
        assertNotNull(task.getTime());
        assertEquals(1,task.getAmountOfSubs());
        assertEquals(LocalDateTime.of(2020, 11, 24, 10, 0),task.getTime());
        assertEquals("don't forget birthday",task.getName());
        assertEquals("don't forget your own birthday!",task.getDescription());


        assertNotNull(task.getTime());

        assertEquals(task.getTasks().get(0), sub);


    }
}