package org.ecommerce.user.dtos;

import lombok.Data;

@Data
public class AddressDto {
    String street;
    String city;
    String state;
    String country;
    String zipcode;
}
