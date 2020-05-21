package com.biteit.rsocket.responder.db.repository;

import com.biteit.rsocket.responder.db.model.Reading;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReadingRepository extends ReactiveMongoRepository<Reading, String> {
    Flux<Reading> findAllByWorksId(String worksId);
}
