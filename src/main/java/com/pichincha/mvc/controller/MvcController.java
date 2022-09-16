package com.pichincha.mvc.controller;

import com.pichincha.mvc.service.MvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MvcController {

  /*
   * Se recomienda usar inyección de dependecias por constructor
   * en vez de @Autowired, en caso de usar Lombok, puede utilizar
   * la anotación @RequiredArgsConstructor
   * */

  private final MvcService mvcService;
  private final MvcService verificationService;


  @GetMapping("/mvc")
  public ResponseEntity<String> getOffer() {
    mvcService.isFinancialAndLegalEligible("clientId");
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
