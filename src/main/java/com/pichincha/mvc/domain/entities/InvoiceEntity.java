package com.pichincha.mvc.domain.entities;

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
@Entity(name = "INVOICE")
public class InvoiceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(nullable = false)
    Double total;

    @Column(name = "TOTAL_PAID", nullable = false)
    Double totalPaid;

    @Column(nullable = false)
    Double discount = 0.0;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = false)
    CustomerEntity customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    List<InvoiceDetailEntity> detail;
}