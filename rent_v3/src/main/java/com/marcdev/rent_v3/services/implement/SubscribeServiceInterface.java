package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Subscribe;
import com.marcdev.rent_v3.model.User;

import java.util.Optional;

public interface SubscribeServiceInterface {

    public boolean createSubscribe(Long id, Long b);

    public String deleteSubscribe(Long id);

    public Iterable<Subscribe> getSub();

}
