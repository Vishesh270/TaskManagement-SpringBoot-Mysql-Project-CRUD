package com.taskManagement.taskManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.taskManagement.taskManagement.Entity.Tasks;
import com.taskManagement.taskManagement.Entity.User;
import com.taskManagement.taskManagement.Service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save-user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userRes = userService.saveUser(user);
        return new ResponseEntity<>(userRes, HttpStatus.OK);
    }
    @PostMapping("/delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId) {
        String res = userService.deleteUser(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/deleteTask/{userId}/{taskIdtoDelete}")
    public ResponseEntity<String> deleteTaskofUserbyId(@PathVariable("userId") Integer userId,
            @PathVariable("taskIdtoDelete") List<Integer> taskIdToDelete) {
        String msg = userService.deleteTaskofUserbyId(userId, taskIdToDelete);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getUserTasks/{userId}")
    public ResponseEntity<List<Tasks>> createUser(@PathVariable("userId") Integer userId) {
        List<Tasks> res=userService.getUserTasksById(userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/edit-task/{userId}/{taskId}")
    public ResponseEntity<String> editTaskOfExistingUser(@PathVariable("userId") Integer userId,@PathVariable("taskId") Integer taskId,@RequestBody Tasks updatedTasks){
        String res=userService.editTaskOfExistingUser(userId, taskId, updatedTasks);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }





    


}
