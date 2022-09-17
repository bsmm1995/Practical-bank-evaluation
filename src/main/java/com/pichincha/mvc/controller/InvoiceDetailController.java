package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.InvoiceDetailDTO;
import com.pichincha.mvc.service.InvoiceDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/invoice-details")
@RequiredArgsConstructor
public class InvoiceDetailController {
    private final InvoiceDetailService invoiceDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetailDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(invoiceDetailService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDetailDTO>> getAll() {
        return ResponseEntity.ok(invoiceDetailService.getAll());
    }

    @PostMapping
    public ResponseEntity<URI> create(@RequestBody @Valid InvoiceDetailDTO data) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(invoiceDetailService.create(data)).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDetailDTO> update(@PathVariable Long id, @RequestBody @Valid InvoiceDetailDTO data) {
        return ResponseEntity.ok(invoiceDetailService.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        invoiceDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
