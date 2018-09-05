package com.wuwii.security;

import com.wuwii.model.domain.AdminUser;
import com.wuwii.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by KronChan on 2018/4/27 18:34.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final AdminUserService adminUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserService.findByUsername(username);
        String password = adminUser.getPassword();
        //return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        return User.withUsername(username)
                .disabled(adminUser.getEnable())
                .password(password)
                .build();
    }
}
