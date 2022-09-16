package com.pichincha.mvc.domain.dto;

import com.pichincha.mvc.domain.entities.ShoppingCartEntity;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class CustomerDTO implements Serializable {
    Long id;
    String name;
    String lastName;
    String dni;
    List<InvoiceDTO> invoices;
    List<ShoppingCartEntity> carts;
}