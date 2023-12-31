package com.frankie.usercenter.modle.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author frankie
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -5740830140326946114L;

    private String userAccount;
    private String userPassword;
}
