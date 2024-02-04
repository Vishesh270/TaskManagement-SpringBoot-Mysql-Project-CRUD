package com.taskManagement.taskManagement.Dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.taskManagement.taskManagement.Entity.Tasks;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Tasks createTask(Tasks task) {
        Tasks taskObj = Tasks.builder().taskName(task.getTaskName()).taskId(task.getTaskId())
                .taskDescription(task.getTaskDescription()).status(task.getStatus()).build();
        entityManager.persist(taskObj);
        return taskObj;
    }

    @Override
    public String editTask(Integer taskId, Tasks UpdatedTask) {
        Tasks tasobj = entityManager.find(Tasks.class, taskId);
        String msg = "";
        if (tasobj != null) {
            // Only decsription and Status are updated
            tasobj.setTaskDescription(UpdatedTask.getTaskDescription());
            tasobj.setStatus(UpdatedTask.getStatus());
            entityManager.persist(tasobj);
            msg = "task Updated successfully";
        } else {
            msg = "task not found";
        }
        return msg;
    }

    @Override
    public String deleteTaskById(Integer taskId) {

        Tasks tasks = entityManager.find(Tasks.class, taskId);
        String msg = "";
        if (tasks != null) {
            entityManager.remove(tasks);
            msg = "task deleted succefully" + tasks.getTaskName();
        } else {
            msg = "task not found";
        }
        return msg;
    }

    @Override
    public List<Tasks> getAllTasks() {
        TypedQuery<Tasks> query = entityManager.createQuery("SELECT t FROM Tasks t", Tasks.class);
        return query.getResultList();
    }

}
