package com.pichincha.mvc.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity(name = "CUSTOMER")
public class CustomerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(name = "LAST_NAME", nullable = false)
    String name;

    @Column(name = "LAST_NAME", nullable = false)
    String lastName;

    @Column(name = "DNI", nullable = false)
    String dni;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<InvoiceEntity> invoices;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<ShoppingCartEntity> carts;
}