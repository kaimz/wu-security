package com.wuwii.service;

import com.wuwii.model.domain.AdminMenu;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by KronChan on 18/10/31 下午5:50.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminMenuServiceTest {
    @Autowired
    private AdminMenuService adminMenuService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findMenuAuthByUserName() {
    }

    @Test
    public void add() {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setAuth("test.add");
        adminMenu.setCode("测试新增");
        adminMenu.setEnable(true);
        adminMenu.setName("测试新增");
        adminMenu.setCode("test-add");
        adminMenuService.add(adminMenu);
    }
}