package com.wuwii.service.impl;

import com.wuwii.model.domain.AdminRole;
import com.wuwii.repository.AdminRoleRepository;
import com.wuwii.service.AdminRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by KronChan on 18/10/31 下午5:00.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminRoleServiceImpl implements AdminRoleService {
    private final AdminRoleRepository adminRoleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AdminRole add(AdminRole adminRole) {
        return adminRoleRepository.save(adminRole);
    }
}
