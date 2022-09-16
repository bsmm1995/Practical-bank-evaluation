package com.pichincha.mvc.domain.entities;

import com.pichincha.mvc.domain.enums.ShoppingCartStatus;
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
@Entity(name = "SHOPPING_CAR")
public class ShoppingCartEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(nullable = false)
    ShoppingCartStatus status;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = false)
    CustomerEntity customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shoppingCart")
    List<ProductEntity> products;
}