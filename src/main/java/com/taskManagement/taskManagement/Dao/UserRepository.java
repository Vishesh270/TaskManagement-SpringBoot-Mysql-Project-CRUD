package com.taskManagement.taskManagement.Dao;

import java.util.List;

import com.taskManagement.taskManagement.Entity.Tasks;
import com.taskManagement.taskManagement.Entity.User;

public interface UserRepository {
    public User createUser(User user);
    public String deleteUser(Integer userId);
    public List<Tasks> getUserTasksById(Integer userId);
    public String deleteTaskofUserbyId(Integer userId,List <Integer> taskIdtoDelete);
    public String editTaskOfExistingUser(Integer userId,Integer taskId,Tasks updatedTasks);
    
}
