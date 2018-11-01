package com.wuwii.service.impl;

import com.wuwii.model.domain.AdminMenu;
import com.wuwii.model.domain.AdminRole;
import com.wuwii.model.domain.AdminRoleMenu;
import com.wuwii.model.domain.AdminUser;
import com.wuwii.model.domain.AdminUserRole;
import com.wuwii.repository.AdminMenuRepository;
import com.wuwii.service.AdminMenuService;
import com.wuwii.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by KronChan on 18/9/10 下午12:51.
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AdminMenuServiceImpl implements AdminMenuService {
    private final AdminMenuRepository adminMenuRepository;
    private final AdminUserService adminUserService;

    @Override
    public Set<String> findMenuAuthByUserName(String username) {
        AdminUser adminUser = adminUserService.findByUsername(username);
        if (adminUser == null || CollectionUtils.isEmpty(adminUser.getUserRoles())) {
            return Collections.emptySet();
        }
        Set<AdminUserRole> userRoles = adminUser.getUserRoles();
        return userRoles.stream()
                .map(AdminUserRole::getRole)
                .map(AdminRole::getRoleMenus)
                .flatMap(Collection::stream)
                .map(AdminRoleMenu::getMenu)
                .map(AdminMenu::getAuth)
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AdminMenu add(AdminMenu adminMenu) {
        return adminMenuRepository.save(adminMenu);
    }
}
