package com.taskManagement.taskManagement.Dao;
import java.util.List;
import com.taskManagement.taskManagement.Entity.Tasks;

public interface TaskDao {
    public Tasks createTask(Tasks task);
    public String editTask(Integer taskId,Tasks UpdatedTask);
    public String deleteTaskById(Integer taskId);
    public List<Tasks> getAllTasks();
   

}
