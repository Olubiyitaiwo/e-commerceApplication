package org.olubiyi.ecommerce.Repository;

import org.olubiyi.ecommerce.dtos.UserRequest;
import org.olubiyi.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
