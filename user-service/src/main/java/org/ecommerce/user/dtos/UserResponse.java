package org.ecommerce.user.dtos;


import lombok.Data;
import org.ecommerce.user.models.UserRole;


@Data
public class UserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role;
    private AddressDto address;
}
