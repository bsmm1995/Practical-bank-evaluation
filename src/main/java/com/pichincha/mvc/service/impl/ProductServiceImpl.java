package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.ProductDTO;
import com.pichincha.mvc.domain.entities.ProductEntity;
import com.pichincha.mvc.repository.ProductRepository;
import com.pichincha.mvc.service.ProductService;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO getById(Long recordId) {
        return this.toDto(this.getEntityById(recordId));
    }

    @Override
    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Long create(ProductDTO data) {
        ProductEntity entity = this.toEntity(data);
        return this.toDto(productRepository.save(entity)).getId();
    }

    @Override
    public ProductDTO update(Long recordId, ProductDTO data) {
        ProductEntity entity = this.getEntityById(recordId);
        entity.setName(data.getName());
        entity.setPrice(data.getPrice());
        entity.setQuantity(data.getQuantity());
        return this.toDto(productRepository.save(entity));
    }

    @Override
    public void deleteById(Long recordId) {
        ProductEntity entity = this.getEntityById(recordId);
        productRepository.delete(entity);
    }

    private ProductEntity getEntityById(Long recordId) {
        return productRepository.findById(recordId).orElseThrow();
    }

    private ProductDTO toDto(ProductEntity entity) {
        return Mapper.modelMapper().map(entity, ProductDTO.class);
    }

    private ProductEntity toEntity(ProductDTO dto) {
        return Mapper.modelMapper().map(dto, ProductEntity.class);
    }
}
