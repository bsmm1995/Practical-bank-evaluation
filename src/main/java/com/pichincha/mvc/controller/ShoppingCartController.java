package com.pichincha.mvc.controller;

import com.pichincha.mvc.domain.dto.ShoppingCartDTO;
import com.pichincha.mvc.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(shoppingCartService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCartDTO>> getAll() {
        return ResponseEntity.ok(shoppingCartService.getAll());
    }

    @PostMapping
    public ResponseEntity<URI> create(@RequestBody @Valid ShoppingCartDTO data) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(shoppingCartService.create(data)).toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingCartDTO> update(@PathVariable Long id, @RequestBody @Valid ShoppingCartDTO data) {
        return ResponseEntity.ok(shoppingCartService.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        shoppingCartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
