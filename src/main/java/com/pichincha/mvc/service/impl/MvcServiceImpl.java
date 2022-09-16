package com.pichincha.mvc.service.impl;

import com.pichincha.mvc.repository.AccountRepository;
import com.pichincha.mvc.repository.TemplateRepository;
import com.pichincha.mvc.service.MvcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MvcServiceImpl implements MvcService {

  private final AccountRepository accountRepository;
  private final TemplateRepository templateRepository;

  @Override
  public boolean isFinancialAndLegalEligible(String clientId) {
    return true;
  }
}
