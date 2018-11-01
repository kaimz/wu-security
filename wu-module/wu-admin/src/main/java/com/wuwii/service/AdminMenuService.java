package com.wuwii.service;

import com.wuwii.model.domain.AdminMenu;

import java.util.Set;

/**
 * Created by KronChan on 18/9/10 下午12:50.
 */
public interface AdminMenuService {
    Set<String> findMenuAuthByUserName(String username);

    AdminMenu add(AdminMenu adminMenu);
}
