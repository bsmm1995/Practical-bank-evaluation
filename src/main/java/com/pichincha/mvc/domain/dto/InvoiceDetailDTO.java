package com.pichincha.mvc.domain.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class InvoiceDetailDTO implements Serializable {
    Long id;
    Long productId;
    String productName;
    Double price;
    Double quantity;
    Double total;
    Double discount = 0.0;
}