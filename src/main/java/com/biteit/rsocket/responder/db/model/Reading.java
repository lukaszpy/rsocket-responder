package com.biteit.rsocket.responder.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document
public class Reading {
    @Id
    private String id;
    private String meterId;
    private String worksId;
    private long value;
    private Date readingDate;
}
