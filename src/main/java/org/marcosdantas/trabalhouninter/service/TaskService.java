package org.marcosdantas.trabalhouninter.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.marcosdantas.trabalhouninter.entity.TaskEntity;
import org.marcosdantas.trabalhouninter.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
  private final TaskRepository taskRepository;
  public List<TaskEntity> findAllTasks () {
    return taskRepository.findAll();
  }
  public TaskEntity createTask(TaskEntity taskEntity) {
    return taskRepository.save(taskEntity);
  }
  public TaskEntity updateTaskById(Long id, TaskEntity taskEntity) {
    return taskRepository.findById(id)
        .map(task -> {
          task.setTaskName(taskEntity.getTaskName());
          task.setTaskResponsible(taskEntity.getTaskResponsible());
          return taskRepository.save(task);
        })
        .orElse(null);
  }
  public void deleteTaskById(Long id) {
    taskRepository.deleteById(id);
  }
}
