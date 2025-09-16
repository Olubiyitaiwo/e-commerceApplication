package org.olubiyi.ecommerce;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/Api/Users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/Api/Users/{id}")
    public ResponseEntity<User> getUsers(@PathVariable Long id){
//        User user = userService.fetchUserById(id);
//        if(user == null){
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(userService.fetchUserById(id),  HttpStatus.OK);

        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/Api/Users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/Api/Users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser){
       boolean updated = userService.updateUser(id, updatedUser);
       return  updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
