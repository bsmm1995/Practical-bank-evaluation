package com.pichincha.mvc.domain.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class ProductDTO implements Serializable {
    Long id;
    String name;
    String price;
    Double quantity;
    PromotionDTO promotion;
}