package com.pichincha.mvc.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;


@Getter
@Setter
@FieldDefaults(level = PRIVATE)
@Entity(name = "PROMOTION")
public class PromotionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(name = "START_DATE", nullable = false)
    LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    LocalDateTime endDate;

    @Column(nullable = false)
    Double percentage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
    List<ProductEntity> products;
}