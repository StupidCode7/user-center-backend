package com.frankie.usercenter.service;
import java.util.Date;

import com.frankie.usercenter.modle.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 用户服务测试
 *
 * @author frankie
 */

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("frankie");
        user.setUserAccount("123");
        user.setAvatarUrl("https://qnm.hunliji.com/o_1gjo5pg1uf9a161f8410i6v2n8n.jpg");
        user.setGender((byte)0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("4567");


        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "frankie";
        String userPassword = "";
        String checkPassword = "12345678";
        String planetCode = "1";
        long result = userService.userRegister(userAccount,userPassword,checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "yu";
        result = userService.userRegister(userAccount,userPassword,checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "fran1!kie";
        userPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "qwqwqw";
        userPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword, planetCode);
        Assertions.assertEquals(-1, result);
        userAccount = "qwqwqw111";
        userPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword, planetCode);
        Assertions.assertTrue(result > 0);

    }
}