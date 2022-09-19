package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.InvoiceDTO;
import com.pichincha.mvc.domain.entities.InvoiceDetailEntity;
import com.pichincha.mvc.domain.entities.InvoiceEntity;
import com.pichincha.mvc.repository.InvoiceRepository;
import com.pichincha.mvc.service.InvoiceService;
import com.pichincha.mvc.util.Constants;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
        entity.setTotal(getTotalFromDetail(entity.getDetail()));
        entity.setDiscount(getDiscountFromTotal(entity.getTotal()));
        entity.setTotalPaid(entity.getTotal() - entity.getDiscount());
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

    private Double getDiscountFromTotal(Double total) {
        return total > Constants.MAXIMUM_FOR_DISCOUNT ? total * Constants.DISCOUNT_PERCENTAGE : 0;
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

    private Double getTotalFromDetail(List<InvoiceDetailEntity> detail) {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        detail.forEach(e -> total.updateAndGet(v -> (v + e.getTotal())));
        return total.get();
    }
}
