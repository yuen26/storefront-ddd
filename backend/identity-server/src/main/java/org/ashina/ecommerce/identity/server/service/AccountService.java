package org.ashina.ecommerce.identity.server.service;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.identity.server.dto.request.CreateAccountRequest;
import org.ashina.ecommerce.identity.server.model.Account;
import org.ashina.ecommerce.identity.server.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(CreateAccountRequest request) {
        Account account = new Account();
        account.setEmail(request.getEmail());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        accountRepository.save(account);
    }
}
