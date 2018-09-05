package com.wuwii.service;

import com.wuwii.model.domain.AdminUser;

/**
 * Created by KronChan on 18/8/27 下午11:17.
 */
public interface AdminUserService {

    void addUser(AdminUser adminUser);

    AdminUser findById(Long id);

    AdminUser findByUsername(String username);
}
