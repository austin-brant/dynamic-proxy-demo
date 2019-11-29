package com.austin.study.test.proxy.impl;

import java.util.Date;

import com.austin.study.test.proxy.UserService;

/**
 * 静态代理，达到了功能增强的目的，而且没有侵入原代码，这是静态代理的一个优点。
 *
 * @author Austin
 * @since 2019/11/28 17:41   Thu
 */
public class UserServiceProxy implements UserService {
    private UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    public void select() {
        before();
        target.select();    // 这里才实际调用真实主题角色的方法
        after();
    }

    public void update() {
        before();
        target.update();    // 这里才实际调用真实主题角色的方法
        after();
    }

    private void before() {     // 在执行方法之前执行
        System.out.printf("log start time [%s] \n", new Date());
    }

    private void after() {      // 在执行方法之后执行
        System.out.printf("log end time [%s] \n", new Date());
    }
}
