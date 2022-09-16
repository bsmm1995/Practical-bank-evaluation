package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.PromotionDTO;
import com.pichincha.mvc.domain.entities.PromotionEntity;
import com.pichincha.mvc.repository.PromotionRepository;
import com.pichincha.mvc.service.PromotionService;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Override
    public PromotionDTO getById(Long recordId) {
        return this.toDto(this.getEntityById(recordId));
    }

    @Override
    public List<PromotionDTO> getAll() {
        return promotionRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Long create(PromotionDTO data) {
        PromotionEntity entity = this.toEntity(data);
        return this.toDto(promotionRepository.save(entity)).getId();
    }

    @Override
    public PromotionDTO update(Long recordId, PromotionDTO data) {
        PromotionEntity entity = this.getEntityById(recordId);
        entity.setName(data.getName());
        entity.setPercentage(data.getPercentage());
        entity.setStartDate(data.getStartDate());
        entity.setEndDate(data.getEndDate());
        return this.toDto(promotionRepository.save(entity));
    }

    @Override
    public void deleteById(Long recordId) {
        PromotionEntity entity = this.getEntityById(recordId);
        promotionRepository.delete(entity);
    }

    private PromotionEntity getEntityById(Long recordId) {
        return promotionRepository.findById(recordId).orElseThrow();
    }

    private PromotionDTO toDto(PromotionEntity entity) {
        return Mapper.modelMapper().map(entity, PromotionDTO.class);
    }

    private PromotionEntity toEntity(PromotionDTO dto) {
        return Mapper.modelMapper().map(dto, PromotionEntity.class);
    }
}
