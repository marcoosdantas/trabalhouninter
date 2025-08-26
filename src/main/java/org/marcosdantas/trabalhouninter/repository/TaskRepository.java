package org.marcosdantas.trabalhouninter.repository;

import org.marcosdantas.trabalhouninter.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
