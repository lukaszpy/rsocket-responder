package com.biteit.rsocket.responder.service;

import com.biteit.rsocket.responder.db.model.Reading;
import com.biteit.rsocket.responder.db.repository.ReadingRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Log4j2
@Service
public class ReadingService {
    private final ReadingRepository readingRepository;

    public ReadingService(ReadingRepository readingRepository) {
        this.readingRepository = readingRepository;
    }

    public Flux<Reading> readingsForWorks(String worksId){
        return readingRepository.findAllByWorksId(worksId)
                .doOnNext(reading -> log.info("Reading {}", reading));
    }
}
