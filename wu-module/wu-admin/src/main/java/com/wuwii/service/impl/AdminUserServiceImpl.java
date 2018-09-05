package com.wuwii.service.impl;

import com.wuwii.model.domain.AdminUser;
import com.wuwii.repository.AdminUserRepository;
import com.wuwii.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by KronChan on 18/8/27 下午11:18.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminUserServiceImpl implements AdminUserService {

    private final AdminUserRepository adminUserRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void addUser(AdminUser adminUser) {
        String encodePassword = passwordEncoder.encode(adminUser.getPassword());
        adminUser.setPassword(encodePassword);
        adminUserRepository.save(adminUser);
    }

    @Override
    public AdminUser findById(Long id) {
        return adminUserRepository.findById(id).orElse(AdminUser.EMPTY);
    }

    @Override
    public AdminUser findByUsername(String username) {
        return adminUserRepository.findAdminUserByUsername(username).orElse(AdminUser.EMPTY);
    }
}
