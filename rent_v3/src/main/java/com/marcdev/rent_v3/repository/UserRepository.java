package com.marcdev.rent_v3.repository;

import com.marcdev.rent_v3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPhoneNumber(String email, int phoneNumber);

    Optional<Iterable<User>> findByUserNameContains(String username);


}
