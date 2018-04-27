package com.wuwii.repository;

import com.wuwii.model.domain.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KronChan on 2018/4/24 17:50.
 */
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
}
