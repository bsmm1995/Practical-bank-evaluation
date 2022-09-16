package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.ShoppingCartDTO;
import com.pichincha.mvc.domain.entities.ShoppingCartEntity;
import com.pichincha.mvc.repository.ShoppingCartRepository;
import com.pichincha.mvc.service.ShoppingCartService;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartDTO getById(Long recordId) {
        return this.toDto(this.getEntityById(recordId));
    }

    @Override
    public List<ShoppingCartDTO> getAll() {
        return shoppingCartRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Long create(ShoppingCartDTO data) {
        ShoppingCartEntity entity = this.toEntity(data);
        return this.toDto(shoppingCartRepository.save(entity)).getId();
    }

    @Override
    public ShoppingCartDTO update(Long recordId, ShoppingCartDTO data) {
        ShoppingCartEntity entity = this.getEntityById(recordId);
        return this.toDto(shoppingCartRepository.save(entity));
    }

    @Override
    public void deleteById(Long recordId) {
        ShoppingCartEntity entity = this.getEntityById(recordId);
        shoppingCartRepository.delete(entity);
    }

    private ShoppingCartEntity getEntityById(Long recordId) {
        return shoppingCartRepository.findById(recordId).orElseThrow();
    }

    private ShoppingCartDTO toDto(ShoppingCartEntity entity) {
        return Mapper.modelMapper().map(entity, ShoppingCartDTO.class);
    }

    private ShoppingCartEntity toEntity(ShoppingCartDTO dto) {
        return Mapper.modelMapper().map(dto, ShoppingCartEntity.class);
    }
}
