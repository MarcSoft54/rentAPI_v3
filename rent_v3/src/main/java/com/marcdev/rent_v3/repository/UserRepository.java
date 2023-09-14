package com.marcdev.rent_v3.repository;

import com.marcdev.rent_v3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPhoneNumber(String email, Long phoneNumber);

    Optional<Iterable<User>> findByUserNameContains(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUserNameOrEmail(String word, String email);

    Optional<User> findByUserName(String username);


}
