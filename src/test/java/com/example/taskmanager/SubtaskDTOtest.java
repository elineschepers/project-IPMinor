package com.example.taskmanager;

import com.example.taskmanager.model.dto.SubTaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubtaskDTOtest {

    private SubTaskDTO subTaskDTO = new SubTaskDTO();

    @Test
    public void testSubtasksDTO()
    {
        subTaskDTO.setDescription("ok");
        subTaskDTO.setName("naam");


        assertEquals("ok",subTaskDTO.getDescription());
        assertEquals("naam",subTaskDTO.getName());
        //assertNotNull(subTaskDTO.getId());

        subTaskDTO.setId(4);
        assertEquals(4,subTaskDTO.getId());
    }
}
