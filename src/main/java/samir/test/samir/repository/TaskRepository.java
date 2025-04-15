package samir.test.samir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import samir.test.samir.feature.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM task WHERE completed = false", nativeQuery = true)
    List<Task> findByInCompleted();

    @Query(value = "SELECT * FROM task", nativeQuery = true)
    List<Task> findAllTasks();
}