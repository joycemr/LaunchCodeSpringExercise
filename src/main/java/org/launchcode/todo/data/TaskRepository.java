package org.launchcode.todo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.launchcode.todo.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
}
