package com.pichincha.mvc.domain.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class PromotionDTO implements Serializable {
    Long id;
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Double percentage;
}