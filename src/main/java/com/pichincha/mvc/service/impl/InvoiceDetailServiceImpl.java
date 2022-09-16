package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.InvoiceDetailDTO;
import com.pichincha.mvc.domain.entities.InvoiceDetailEntity;
import com.pichincha.mvc.repository.InvoiceDetailRepository;
import com.pichincha.mvc.service.InvoiceDetailService;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public InvoiceDetailDTO getById(Long recordId) {
        return this.toDto(this.getEntityById(recordId));
    }

    @Override
    public List<InvoiceDetailDTO> getAll() {
        return invoiceDetailRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Long create(InvoiceDetailDTO data) {
        InvoiceDetailEntity entity = this.toEntity(data);
        return this.toDto(invoiceDetailRepository.save(entity)).getId();
    }

    @Override
    public InvoiceDetailDTO update(Long recordId, InvoiceDetailDTO data) {
        InvoiceDetailEntity entity = this.getEntityById(recordId);
        entity.setTotal(data.getTotal());
        return this.toDto(invoiceDetailRepository.save(entity));
    }

    @Override
    public void deleteById(Long recordId) {
        InvoiceDetailEntity entity = this.getEntityById(recordId);
        invoiceDetailRepository.delete(entity);
    }

    private InvoiceDetailEntity getEntityById(Long recordId) {
        return invoiceDetailRepository.findById(recordId).orElseThrow();
    }

    private InvoiceDetailDTO toDto(InvoiceDetailEntity entity) {
        return Mapper.modelMapper().map(entity, InvoiceDetailDTO.class);
    }

    private InvoiceDetailEntity toEntity(InvoiceDetailDTO dto) {
        return Mapper.modelMapper().map(dto, InvoiceDetailEntity.class);
    }
}
