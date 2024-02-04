package com.taskManagement.taskManagement.Service;
import java.util.List;
import com.taskManagement.taskManagement.Entity.Tasks;

public interface TaskService {
    public Tasks createTask(Tasks task);
    public String editTask(Integer taskId,Tasks updatedTasks);
    public String deleteTaskById(Integer taskId);
    public List<Tasks> getAllTask();
   
}
