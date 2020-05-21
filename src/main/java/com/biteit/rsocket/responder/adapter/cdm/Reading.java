package com.biteit.rsocket.responder.adapter.cdm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reading {
    private String meterId;
    private String worksId;
    private long value;
    private Date readingDate;

    public Reading withMeterId(final String meterId) {
        this.meterId = meterId;
        return this;
    }

    public Reading withWorksId(final String worksId) {
        this.worksId = worksId;
        return this;
    }

    public Reading withValue(final long value) {
        this.value = value;
        return this;
    }

    public Reading withReadingDate(final Date readingDate) {
        this.readingDate = readingDate;
        return this;
    }


}
