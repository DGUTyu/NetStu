package com.wxdgut.server.response.entity;

/**
 * @author jiajian.yu
 * @program: NetStudy
 * @date 2022-10-20 14:33:51
 * Copyright (c) 2022 http://wxdgut.com
 * Email: hello_luyao@163.com
 * Profile:
 */
public class UserInfoEntitiy {
    public String userName;
    public String userSex;

    public UserInfoEntitiy() {
    }

    public UserInfoEntitiy(String userName, String userSex) {
        this.userName = userName;
        this.userSex = userSex;
    }
}
