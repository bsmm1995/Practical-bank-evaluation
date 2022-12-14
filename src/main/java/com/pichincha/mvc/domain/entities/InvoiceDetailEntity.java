package com.pichincha.mvc.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity(name = "INVOICE_DETAIL")
public class InvoiceDetailEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(name = "PRODUCT_ID", nullable = false)
    Long productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    String productName;

    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    Double quantity;

    @Column(nullable = false)
    Double total;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID", nullable = false, updatable = false)
    InvoiceEntity invoice;
}