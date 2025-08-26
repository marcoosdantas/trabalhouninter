package org.marcosdantas.trabalhouninter.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.marcosdantas.trabalhouninter.entity.TaskEntity;
import org.marcosdantas.trabalhouninter.service.TaskService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/findAllTasks")
    public List<TaskEntity> findAllTasks () {
      return taskService.findAllTasks();
    }
  @PostMapping("/createTask")
  public TaskEntity createNewTask (@RequestBody TaskEntity taskEntity) {
    return taskService.createTask(taskEntity);
  }
  @PutMapping("/updateTask/{id}")
  public TaskEntity createNewTask (@PathVariable Long id, @RequestBody TaskEntity taskEntity) {
    return taskService.updateTaskById(id, taskEntity);
  }
  @DeleteMapping("/deleteTask/{id}")
  public void deleteTaskById (@PathVariable Long id) {
      taskService.deleteTaskById(id);
  }
}
