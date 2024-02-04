package com.taskManagement.taskManagement.Service;
import java.util.List;
import com.taskManagement.taskManagement.Entity.Tasks;
import com.taskManagement.taskManagement.Entity.User;

public interface UserService {
    
    public User saveUser(User user);
    public String deleteUser(Integer userId);
    public List<Tasks> getUserTasksById(Integer taskId);
    public String deleteTaskofUserbyId(Integer userId,List <Integer> taskIdtoDelete);
    public String editTaskOfExistingUser(Integer userId,Integer taskId,Tasks updatedTasks);

}