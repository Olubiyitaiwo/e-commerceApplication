package org.ecommerce.user.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

    Long id;
    String street;
    String city;
    String state;
    String country;
    String zipcode;
}
