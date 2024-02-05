package com.taskManagement.taskManagement.Dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.taskManagement.taskManagement.Entity.Tasks;
import com.taskManagement.taskManagement.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User createUser(User user) {
        User userObj = User.builder().username(user.getUsername()).userId(user.getUserId()).tasks(user.getTasks())
                .build();
        entityManager.persist(userObj);
        return userObj;
    }

    @Override
    public String deleteUser(Integer userId) {
        User res = entityManager.find(User.class, userId);
        String msg = "";
        if (res != null) {
            entityManager.remove(res);
            msg = "User deleted Succefully " + res.getUserId();
        } else {
            msg = "User not found";
        }
        return msg;
    }

    @Override
    public List<Tasks> getUserTasksById(Integer userId) {
        TypedQuery<Tasks> query = entityManager
                .createQuery("SELECT t FROM Tasks t inner join User u on u.id =:userId", Tasks.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public String deleteTaskofUserbyId(Integer userId, List<Integer> taskIdtoDelete) {
        User user = entityManager.find(User.class, userId);
        String msg = "";
        for (Integer taskId : taskIdtoDelete) {
            Tasks t = entityManager.find(Tasks.class, taskId);
            user.getTasks().remove(t);
            entityManager.remove(t);
            msg = "task deleted successfully";
        }
        return msg;
    }

    @Override
    public String editTaskOfExistingUser(Integer userId, Integer taskId,Tasks updatedTasks) {
        String msg="";
        User user=entityManager.find(User.class, userId);
        if(user==null){
            msg="user not found";
        }
        Tasks taskToupdate=(Tasks) user.getTasks().stream().filter(
            tasks->(tasks.getTaskId().equals(taskId)))
            .findFirst()
            .orElse(null);
        
        if(taskToupdate==null){
            msg="task not found for the given user";
        }
        taskToupdate.setTaskDescription(updatedTasks.getTaskDescription());
        taskToupdate.setStatus(updatedTasks.getStatus());
        entityManager.merge(user);
        msg="task updated succefully";

        return msg;
    }

    @Override
    public String assignTaskToexistingUser(Integer userId, Tasks task) {
        User user=entityManager.find(User.class, userId);
        String msg="";
        if(user!=null){
            user.getTasks().add(task);
            entityManager.merge(user);
           msg="task added succefully";  
        }
        else{
            msg="Operation Failed";
        }
        return msg;   
    }

    @Override
    public User getUserDetails(Integer userId) {
        User user=entityManager.find(User.class, userId);
        return user;
    }

}
