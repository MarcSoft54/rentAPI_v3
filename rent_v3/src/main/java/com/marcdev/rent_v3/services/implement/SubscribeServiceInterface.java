package com.marcdev.rent_v3.services.implement;

import com.marcdev.rent_v3.model.Subscribe;

import java.util.Optional;

public interface SubscribeServiceInterface {

    public boolean createSubscribe(Long id, Long b);

    public String deleteSubscribe(Long id);

    public Optional<Subscribe> getSub(Long id);

}
