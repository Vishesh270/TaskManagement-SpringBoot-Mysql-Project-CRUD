package com.taskManagement.taskManagement.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taskManagement.taskManagement.Dao.UserRepository;
import com.taskManagement.taskManagement.Entity.Tasks;
import com.taskManagement.taskManagement.Entity.User;
import jakarta.transaction.Transactional;

@Service(value = "UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User userObject = userRepository.createUser(user);
        return userObject;
    }

    @Override
    public String deleteUser(Integer userId) {
        String res = userRepository.deleteUser(userId);
        return res;
    }

    @Override
    public List<Tasks> getUserTasksById(Integer taskId) {
        List<Tasks> res=userRepository.getUserTasksById(taskId);
        return res;

    }

    @Override
    public String deleteTaskofUserbyId(Integer userId, List<Integer> taskIdtoDelete) {
        String msg = userRepository.deleteTaskofUserbyId(userId, taskIdtoDelete);
        return msg;
    }

    @Override
    public String editTaskOfExistingUser(Integer userId, Integer taskId, Tasks updatedTasks) {
        String msg=userRepository.editTaskOfExistingUser(userId, taskId, updatedTasks);
        return msg;
    }

    @Override
    public String assignTaskToexistingUser(Integer userId, Tasks task) {
        String msg=userRepository.assignTaskToexistingUser(userId, task);
        return msg;
    }

    @Override
    public User getUserDetails(Integer userId) {
        return userRepository.getUserDetails(userId);
    }

}
