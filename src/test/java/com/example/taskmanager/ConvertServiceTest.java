package com.example.taskmanager;

import com.example.taskmanager.model.Subtask;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.dto.TaskDTO;
import com.example.taskmanager.model.service.ConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ConvertServiceTest {

    private Task task = new Task();
    private Subtask subtask = new Subtask();
    @Test
    public void testConverting()
    {
        ConverterService converterService = new ConverterService();

        assertNotNull(converterService.convertToDto(task));
        assertNotNull(converterService.convertToDto(subtask));
    }
}
