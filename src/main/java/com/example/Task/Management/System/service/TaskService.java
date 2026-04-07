package com.example.Task.Management.System.service;

import com.example.Task.Management.System.entity.Task;
import com.example.Task.Management.System.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // 1. Saare tasks get karne ke liye
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // 2. Naya task save karne ke liye
    public Task saveTask(Task task) {
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new RuntimeException("Task title cannot be empty!");
        }
        return repository.save(task);
    }

    // 3. Task delete karne ke liye
    public void deleteTask(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    // 4. Task update (status change) karne ke liye
    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTask = repository.findById(id);

        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return repository.save(task);
        } else {
            throw new RuntimeException("Task not found for update!");
        }
    }
}