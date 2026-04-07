package com.example.Task.Management.System.repository;

import com.example.Task.Management.System.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Standard CRUD operations are inherited here
}