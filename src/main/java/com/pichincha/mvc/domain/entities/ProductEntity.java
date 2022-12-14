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
@Entity(name = "PRODUCT")
public class ProductEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String price;

    @Column(nullable = false)
    Double quantity;

    @ManyToOne
    @JoinColumn(name = "SHOPPING_CART_ID", nullable = false, updatable = false)
    ShoppingCartEntity shoppingCart;

    @ManyToOne
    @JoinColumn(name = "PROMOTION_ID", updatable = false)
    PromotionEntity promotion;
}