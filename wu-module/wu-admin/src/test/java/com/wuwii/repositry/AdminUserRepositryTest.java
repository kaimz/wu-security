package com.wuwii.repositry;

import com.wuwii.model.domain.AdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author KronChan
 * @version 1.0
 * @since <pre>2018/4/24 23:25</pre>
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminUserRepositryTest {
    @Autowired
    private AdminUserRepositry adminUserRepositry;

    @Test
    public void testFindAll() {
        System.out.println(adminUserRepositry.findAll());
    }

    @Test
    public void testAdd() {
        AdminUser user = new AdminUser();
        user.setUsername("kronchan");
        user.setPassword("123456");
        adminUserRepositry.save(user);
    }
}
