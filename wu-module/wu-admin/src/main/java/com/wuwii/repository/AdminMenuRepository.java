package com.wuwii.repository;

import com.wuwii.model.domain.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by KronChan on 18/9/10 下午1:00.
 */
public interface AdminMenuRepository extends JpaRepository<AdminMenu, Long> {
}
