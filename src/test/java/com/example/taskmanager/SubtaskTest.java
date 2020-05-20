package com.example.taskmanager;

import com.example.taskmanager.model.Subtask;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubtaskTest {

    private Subtask subtask = new Subtask();
    @Test
    public void testSubtasks()
    {
        subtask.setNaam("test");
        subtask.setDescription("testen");

        assertEquals("test",subtask.getNaam());
        assertEquals("testen",subtask.getDescription());
        assertNotNull(subtask.getNaam());
        assertNotNull(subtask.getDescription());
        //assertNotNull(subtask.getId()); ???


        subtask.setId(4);
        assertEquals(4,subtask.getId());
    }
}
