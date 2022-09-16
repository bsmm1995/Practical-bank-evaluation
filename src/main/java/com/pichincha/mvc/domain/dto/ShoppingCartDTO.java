package com.pichincha.mvc.domain.dto;

import com.pichincha.mvc.domain.enums.ShoppingCartStatus;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class ShoppingCartDTO implements Serializable {
    Long id;
    ShoppingCartStatus status;
    CustomerOutDTO customer;
    List<ProductDTO> products;
}