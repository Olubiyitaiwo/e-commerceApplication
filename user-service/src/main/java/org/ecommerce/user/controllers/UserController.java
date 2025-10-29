package org.ecommerce.user.controllers;

import lombok.RequiredArgsConstructor;
import org.ecommerce.user.dtos.UserRequest;
import org.ecommerce.user.dtos.UserResponse;
import org.ecommerce.user.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUsers(@PathVariable String id){
//        User user = userService.fetchUserById(id);
//        if(user == null){
//            return ResponseEntity.notFound().build();
//        }
//        return new ResponseEntity<>(userService.fetchUserById(id),  HttpStatus.OK);

        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody UserRequest updatedUser){
       boolean updated = userService.updateUser(id, updatedUser);
       //if(updated)
            //return ResponseEntity.ok( "user updated successfully");
       //return ResponseEntity.notFound().build();
       return  updated ? ResponseEntity.ok("User updated successfully") : ResponseEntity.notFound().build();
    }
}
