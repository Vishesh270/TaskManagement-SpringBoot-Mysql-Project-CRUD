package com.taskManagement.taskManagement.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taskManagement.taskManagement.Entity.Tasks;
import com.taskManagement.taskManagement.Service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create-task")
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
        Tasks res = taskService.createTask(task);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/edit-task/{taskId}")
    public ResponseEntity<String> editTasks(@PathVariable("taskId") Integer taskId, @RequestBody Tasks updatedTasks) {
        String res = taskService.editTask(taskId, updatedTasks);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("delete-task/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("taskId") Integer taskId) {
        String res = taskService.deleteTaskById(taskId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<Tasks>> getAllTasks() {
        List<Tasks> res = taskService.getAllTask();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
