package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.InvoiceDTO;
import com.pichincha.mvc.domain.entities.InvoiceEntity;
import com.pichincha.mvc.repository.InvoiceRepository;
import com.pichincha.mvc.service.InvoiceService;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceDTO getById(Long recordId) {
        return this.toDto(this.getEntityById(recordId));
    }

    @Override
    public List<InvoiceDTO> getAll() {
        return invoiceRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Long create(InvoiceDTO data) {
        InvoiceEntity entity = this.toEntity(data);
        return this.toDto(invoiceRepository.save(entity)).getId();
    }

    @Override
    public InvoiceDTO update(Long recordId, InvoiceDTO data) {
        InvoiceEntity entity = this.getEntityById(recordId);
        entity.setTotal(data.getTotal());
        return this.toDto(invoiceRepository.save(entity));
    }

    @Override
    public void deleteById(Long recordId) {
        InvoiceEntity entity = this.getEntityById(recordId);
        invoiceRepository.delete(entity);
    }

    private InvoiceEntity getEntityById(Long recordId) {
        return invoiceRepository.findById(recordId).orElseThrow();
    }

    private InvoiceDTO toDto(InvoiceEntity entity) {
        return Mapper.modelMapper().map(entity, InvoiceDTO.class);
    }

    private InvoiceEntity toEntity(InvoiceDTO dto) {
        return Mapper.modelMapper().map(dto, InvoiceEntity.class);
    }
}
