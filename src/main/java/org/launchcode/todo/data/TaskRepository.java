package org.launchcode.todo.data;

import org.launchcode.todo.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	// @Query(value = "SELECT t FROM tasks t where t.todo_item_id = ?1", nativeQuery = true)
	// // @Query("SELECT t FROM Task t where t. = ?1")
    // public Optional<List<Task>> findByTodoItemId(int todo_item_id);

}
