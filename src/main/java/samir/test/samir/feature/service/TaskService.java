package samir.test.samir.feature.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import samir.test.samir.feature.TaskReqDto;
import samir.test.samir.feature.model.Task;
import samir.test.samir.feature.model.User;
import samir.test.samir.repository.TaskRepository;
import samir.test.samir.repository.UserRepository;
import samir.test.samir.security.JwtUtil;
import samir.test.samir.util.JsonConvertUtil;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAllTasks();
    }

    public Task createTask(TaskReqDto task, HttpServletRequest request) {
        String token = jwtUtil.extractTokenFromRequest(request);
        Long userId = jwtUtil.extractUserId(token);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Task taskResult = JsonConvertUtil.fromObject(task,Task.class);
        if (taskResult == null){
            throw new RuntimeException("Invalid");
        }
        taskResult.setUser(user);
        return taskRepository.save(taskResult);
    }

    public Task completeTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(true);
        return taskRepository.save(task);
    }

    public List<Task> getIncompleteTasks() {
        return taskRepository.findByInCompleted();
    }
}

