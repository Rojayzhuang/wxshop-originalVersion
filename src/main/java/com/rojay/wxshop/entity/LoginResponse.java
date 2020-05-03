package com.rojay.wxshop.entity;

import com.rojay.wxshop.generate.User;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2020年04月27日  23:00:32
 */

public  class LoginResponse {
    private boolean login;
    private User user;

    public LoginResponse() {
    }


    public static LoginResponse notLogin() {
        return new LoginResponse(false, null);
    }


    public static LoginResponse login(User user) {
        return new LoginResponse(true, user);
    }

    private LoginResponse(boolean login, User user) {
        this.login = login;
        this.user = user;
    }

    public boolean isLogin() {
        return login;
    }

    public User getUser() {
        return user;
    }
}


