package com.austin.study.test.proxy.impl;

import com.austin.study.test.proxy.UserService;

/**
 * @author Austin
 * @since 2019/11/28 18:04   Thu
 */
public class StudentSeviceImpl implements UserService {
    public void select() {
        System.out.println("i am a student , select .");
    }

    public void update() {
        System.out.println("i am a student , update.");
    }
}
