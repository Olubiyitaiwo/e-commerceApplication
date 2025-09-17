package org.olubiyi.ecommerce;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

   // private List<User> userList = new ArrayList<>();
    //private Long nextId = 1L;


    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        //user.setId(nextId++);
        userRepository.save(user);
    }

    public Optional<User> fetchUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean updateUser(Long id, User update) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(update.getFirstName());
                    existingUser.setLastName(update.getLastName());
                    userRepository.save(existingUser);
                    return true;
                }).orElse(false);

    }

}
