package com.marcdev.rent_v3.services.service;

import com.marcdev.rent_v3.model.Subscribe;
import com.marcdev.rent_v3.model.User;
import com.marcdev.rent_v3.repository.SubscribeRepository;
import com.marcdev.rent_v3.repository.UserRepository;
import com.marcdev.rent_v3.services.implement.SubscribeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SubscribeService implements SubscribeServiceInterface {
    @Autowired
    SubscribeRepository subscribeRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public boolean createSubscribe(Long id, Long b) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            var sub = Subscribe.builder()
                    .createAt(Timestamp.valueOf(LocalDateTime.now()))
                    .numberSubscribe(b)
                    .build();
            subscribeRepository.save(sub);
            return true;
        }
        return false;
    }

    @Override
    public String deleteSubscribe(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            subscribeRepository.deleteById(user.get().getId());
            return "success delete";
        }
        return "not found";
    }

    @Override
    public Long getSub() {
        return subscribeRepository.count();
    }
}
