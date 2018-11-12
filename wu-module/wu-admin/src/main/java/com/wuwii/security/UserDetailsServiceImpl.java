package com.wuwii.security;

import com.wuwii.model.domain.AdminUser;
import com.wuwii.service.AdminMenuService;
import com.wuwii.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by KronChan on 2018/4/27 18:34.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminUserService adminUserService;

    private final AdminMenuService adminMenuService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserService.findByUsername(username);
        if (adminUser == null) {
            throw new UsernameNotFoundException(username);
        }
        String password = adminUser.getPassword();
        Set<String> menuAuths = adminMenuService.findMenuAuthByUserName(username);
        String[] authStrings = menuAuths.toArray(new String[0]);
        return User.withUsername(username)
                .disabled(adminUser.getEnable() == null ? false : adminUser.getEnable())
                .password(password)
                .authorities(authStrings)
                .build();
    }
}
