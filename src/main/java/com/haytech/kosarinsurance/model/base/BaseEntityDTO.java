package com.haytech.kosarinsurance.model.base;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseEntityDTO {
    private Boolean isDeleted = false;
    private Date createDatetime = new Timestamp(System.currentTimeMillis());
    private Date updateDatetime = new Timestamp(System.currentTimeMillis());
    private Long creatorUserId;
}
