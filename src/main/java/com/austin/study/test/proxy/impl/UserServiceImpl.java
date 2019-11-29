package com.austin.study.test.proxy.impl;

import com.austin.study.test.proxy.UserService;

/**
 * @author Austin
 * @since 2019/11/28 17:40   Thu
 */
public class UserServiceImpl implements UserService {
    public void select() {
        System.out.println("查询 selectById");
    }

    public void update() {
        System.out.println("更新 update");
    }
}
