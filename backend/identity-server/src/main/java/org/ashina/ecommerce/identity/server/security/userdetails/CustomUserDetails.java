package org.ashina.ecommerce.identity.server.security.userdetails;

import lombok.Getter;
import lombok.Setter;
import org.ashina.ecommerce.identity.server.entity.Account;
import org.ashina.ecommerce.identity.server.service.RoleHelper;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class CustomUserDetails extends User {

    private String id;

    public CustomUserDetails(Account account) {
        super(account.getEmail(), account.getPassword(), RoleHelper.asGrantedAuthorities(account.getRoles()));
        this.id = account.getId();
    }
}
