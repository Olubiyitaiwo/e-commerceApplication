package org.olubiyi.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.olubiyi.ecommerce.Repository.UserRepository;
import org.olubiyi.ecommerce.dtos.AddressDto;
import org.olubiyi.ecommerce.dtos.UserRequest;
import org.olubiyi.ecommerce.dtos.UserResponse;
import org.olubiyi.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

   // private List<User> userList = new ArrayList<>();
    //private Long nextId = 1L;


    public List<UserResponse> fetchAllUsers(){

        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());
    }

    public void addUser(UserRequest userRequest){
        //user.setId(nextId++);

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        userRepository.save(user);
    }

    public Optional<UserResponse> fetchUserById(Long id) {
        return userRepository.findById(id)
                .map(this::mapToUserResponse);
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

    private UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setRole(user.getRole());

        if (user.getAddress() != null) {
            AddressDto addressDto = new AddressDto();

            addressDto.setStreet(user.getAddress().getStreet());
            addressDto.setCity(user.getAddress().getCity());
            addressDto.setState(user.getAddress().getState());
            addressDto.setCountry(user.getAddress().getCountry());
            addressDto.setZipcode(user.getAddress().getZipcode());
            userResponse.setAddress(addressDto);
        }
        return userResponse;

    }

}
