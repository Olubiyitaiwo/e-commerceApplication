package org.olubiyi.ecommerce;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/Api/Users")
    public List<User> getAllUsers(){
        return userService.fetchAllUsers();
    }

    @GetMapping("/Api/Users/{id}")
    public User getUsers(@PathVariable Long id){
        return userService.fetchUserById(id);
    }

    @PostMapping("/Api/Users")
    public String createUser(@RequestBody User user){
        userService.addUser(user);
        return "user added successfully";
    }
}
