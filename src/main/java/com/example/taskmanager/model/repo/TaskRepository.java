package com.example.taskmanager.model.repo;

import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
