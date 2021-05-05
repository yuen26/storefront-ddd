package org.ashina.ecommerce.identity.server.security;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.identity.server.model.Account;
import org.ashina.ecommerce.identity.server.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // =================================================================================================================
    // Dependencies
    // =================================================================================================================

    private final AccountRepository accountRepository;

    // =================================================================================================================
    // Public methods
    // =================================================================================================================

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                   String.format("Email %s not found", username)
                ));
        return new User(account.getEmail(), account.getPassword(), Collections.emptyList());
    }
}
