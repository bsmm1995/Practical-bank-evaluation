package com.pichincha.mvc.domain.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
public class CustomerOutDTO implements Serializable {
    Long id;
    String name;
    String lastName;
    String dni;
}