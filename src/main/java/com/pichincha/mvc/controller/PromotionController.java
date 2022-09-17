package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.PromotionDTO;
import com.pichincha.mvc.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/promotions")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @GetMapping("/{id}")
    public ResponseEntity<PromotionDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(promotionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PromotionDTO>> getAll() {
        return ResponseEntity.ok(promotionService.getAll());
    }

    @PostMapping
    public ResponseEntity<URI> create(@RequestBody @Valid PromotionDTO data) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(promotionService.create(data)).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromotionDTO> update(@PathVariable Long id, @RequestBody @Valid PromotionDTO data) {
        return ResponseEntity.ok(promotionService.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        promotionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
