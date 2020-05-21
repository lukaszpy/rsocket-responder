package com.biteit.rsocket.responder.adapter.mapper;

import com.biteit.rsocket.responder.adapter.cdm.Reading;

public class ReadingMapper {
    public static Reading map(com.biteit.rsocket.responder.db.model.Reading reading){
        return new Reading()
                .withWorksId(reading.getWorksId())
                .withReadingDate(reading.getReadingDate())
                .withMeterId(reading.getMeterId())
                .withValue(reading.getValue());
    }
}
