package com.pichincha.mvc.domain.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class InvoiceDTO implements Serializable {
    Long id;
    Double total;
    Double totalPaid;
    CustomerOutDTO customer;
    List<InvoiceDetailDTO> detail;
}