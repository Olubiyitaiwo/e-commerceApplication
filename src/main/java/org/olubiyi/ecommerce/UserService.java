package org.olubiyi.ecommerce;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> fetchAllUsers(){
        return userList;
    }

    public void addUser(User user){
        user.setId(nextId++);
        userList.add(user);
    }

    public Optional<User> fetchUserById(Long id) {
        return userList.stream().filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public boolean updateUser(Long id, User update) {
        return userList.stream().filter(user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setFirstName(update.getFirstName());
                    existingUser.setLastName(update.getLastName());
                    return true;
                }).orElse(false);
    }
}
