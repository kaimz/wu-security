package com.wuwii.service;

import com.wuwii.model.domain.AdminUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by KronChan on 18/8/27 下午11:26.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminUserServiceTest {

    @Autowired
    private AdminUserService adminUserService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addUser() {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("kronchan");
        adminUser.setPassword("595165463");
        adminUserService.addUser(adminUser);
    }
}