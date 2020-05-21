package com.biteit.rsocket.responder.adapter.cdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingRequest {
    private String worksId;
}
