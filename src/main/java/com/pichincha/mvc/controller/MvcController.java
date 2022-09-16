package com.pichincha.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MvcController {
    @GetMapping
    public ResponseEntity<String> getOffer() {

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
