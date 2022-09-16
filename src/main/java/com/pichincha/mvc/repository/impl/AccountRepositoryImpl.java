package com.pichincha.mvc.repository.impl;

import com.pichincha.mvc.configuration.ApplicationProperties;
import com.pichincha.mvc.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  private final ApplicationProperties applicationProperties;

  public String consultAccounts(String clientId) {
    return null;
  }
}
