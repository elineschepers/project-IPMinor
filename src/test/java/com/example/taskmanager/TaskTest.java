package com.example.taskmanager;


import com.example.taskmanager.model.Subtask;
import com.example.taskmanager.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskTest {

    Task task;
    Subtask sub;
    @Test
    public void testTask()
    {
        task= new Task();
        sub = new Subtask();
        task.setName("don't forget birthday");
        task.setTime(LocalDateTime.of(2020,11,24,10,0));
        task.setDescription("don't forget your own birthday!");
        task.setId(0);

        sub.setNaam("light candles");
        //sub.setTime(LocalDateTime.of(2020,11,24,10,0));
        sub.setDescription("don't forget to light the candles on the birthdaycake!");
        task.addSubtask(sub);

        assertNotNull(task.getSubTasks());
        assertFalse(task.getSubTasks().isEmpty());
        assertEquals(1,task.getSubTasks().size());
        assertNotNull(task.getSubTasks().get(0));
        assertEquals("don't forget birthday",task.getName());
        assertEquals("don't forget your own birthday!",task.getDescription());

        System.out.println(task.getId());
        assertEquals(0,task.getId()); //??

        assertNotNull(task.getTime());

        assertEquals(task.getSubTasks().get(0),sub);

        assertEquals(1,task.getAmountOfSubs());

    }
}
