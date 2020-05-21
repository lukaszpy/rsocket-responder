package com.biteit.rsocket.responder.adapter.output.rsocket;

import com.biteit.rsocket.responder.adapter.cdm.Reading;
import com.biteit.rsocket.responder.adapter.cdm.ReadingRequest;
import com.biteit.rsocket.responder.adapter.mapper.ReadingMapper;
import com.biteit.rsocket.responder.service.ReadingService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class ReadingController {
    private final ReadingService readingService;

    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @MessageMapping("com.biteit.rsocket.v0")
    public Flux<Reading> getReadingsForWorks(ReadingRequest request){
        return readingService.readingsForWorks(request.getWorksId())
                .map(ReadingMapper::map);
    }

    @MessageMapping("com.biteit.rsocket.{worksId}.v0")
    public Flux<Reading> getReadingsForWorksParam(@DestinationVariable String worksId){
        return readingService.readingsForWorks(worksId)
                .map(ReadingMapper::map);
    }
}
