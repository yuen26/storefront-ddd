package org.ashina.ecommerce.identity.server.security.userdetails;

import lombok.RequiredArgsConstructor;
import org.ashina.ecommerce.identity.server.entity.Account;
import org.ashina.ecommerce.identity.server.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    // Dependencies
    // -----------------------------------------------------------------------------------------------------------------

    private final AccountRepository accountRepository;

    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Account account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with email: " + username));
        return new CustomUserDetails(account);
    }
}
