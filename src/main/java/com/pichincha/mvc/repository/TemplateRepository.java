package com.pichincha.mvc.repository;

import com.pichincha.mvc.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<ProductEntity, Long> {

}
