package com.hyk.domain;

/**
 * @param
 * @Description TODO
 * @Author Lindsay
 * @Date 2020/10/6 3:52 PM
 **/
public class LoginVo {


    private final String bizType;
    private final String mobile;
    private final String password;

    public LoginVo(String bizType, String mobile, String password) {
        this.bizType = bizType;
        this.mobile = mobile;
        this.password = password;
    }
}
