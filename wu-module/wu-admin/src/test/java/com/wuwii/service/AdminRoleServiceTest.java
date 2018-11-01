package com.wuwii.service;

import com.wuwii.model.domain.AdminRole;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by KronChan on 18/10/31 下午5:03.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminRoleServiceTest {
    @Autowired
    private AdminRoleService adminRoleService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add() {
        AdminRole adminRole = new AdminRole();
        adminRole.setEnable(true);
        adminRole.setCode("Administrator");
        adminRole.setName("管理员");
        adminRole.setRemark("系统管理员");
        adminRoleService.add(adminRole);
    }
}