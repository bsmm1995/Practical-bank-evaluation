package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.domain.dto.CustomerDTO;
import com.pichincha.mvc.domain.entities.CustomerEntity;
import com.pichincha.mvc.repository.CustomerRepository;
import com.pichincha.mvc.service.CustomerService;
import com.pichincha.mvc.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO getById(Long recordId) {
        return this.toDto(this.getEntityById(recordId));
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Long create(CustomerDTO data) {
        CustomerEntity entity = this.toEntity(data);
        return this.toDto(customerRepository.save(entity)).getId();
    }

    @Override
    public CustomerDTO update(Long recordId, CustomerDTO data) {
        CustomerEntity entity = this.getEntityById(recordId);
        entity.setName(data.getName());
        entity.setLastName(data.getLastName());
        entity.setDni(data.getDni());
        return this.toDto(customerRepository.save(entity));
    }

    @Override
    public void deleteById(Long recordId) {
        CustomerEntity entity = this.getEntityById(recordId);
        customerRepository.delete(entity);
    }

    private CustomerEntity getEntityById(Long recordId) {
        return customerRepository.findById(recordId).orElseThrow();
    }

    private CustomerDTO toDto(CustomerEntity entity) {
        return Mapper.modelMapper().map(entity, CustomerDTO.class);
    }

    private CustomerEntity toEntity(CustomerDTO dto) {
        return Mapper.modelMapper().map(dto, CustomerEntity.class);
    }
}
