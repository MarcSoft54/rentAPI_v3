package com.marcdev.rent_v3.mapperModel;

import com.marcdev.rent_v3.model.Subscribe;
import com.marcdev.rent_v3.modelDTO.SubscribeDto;

public class SubscribeMapper {

    public Subscribe toSubscribe(SubscribeDto subscribeDto){
        return new Subscribe(
                subscribeDto.getNumberSubscribe()
        );
    }

    public SubscribeDto toDto(Subscribe subscribe){
        return new SubscribeDto(
                subscribe.getNumberSubscribe()
        );
    }
    
}
