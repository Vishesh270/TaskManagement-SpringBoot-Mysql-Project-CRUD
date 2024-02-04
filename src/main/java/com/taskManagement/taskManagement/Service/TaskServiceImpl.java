package com.taskManagement.taskManagement.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taskManagement.taskManagement.Dao.TaskDao;
import com.taskManagement.taskManagement.Entity.Tasks;
import jakarta.transaction.Transactional;

@Service(value = "TaskService")
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public Tasks createTask(Tasks task) {
        Tasks res = taskDao.createTask(task);
        return res;
    }

    @Override
    public String editTask(Integer taskId, Tasks updatedTasks) {
        String msg = taskDao.editTask(taskId, updatedTasks);
        return msg;
    }

    @Override
    public String deleteTaskById(Integer taskId) {
        String msg = taskDao.deleteTaskById(taskId);
        return msg;
    }

    @Override
    public List<Tasks> getAllTask() {
        List<Tasks> tasks = taskDao.getAllTasks();
        return tasks;
    }

}
