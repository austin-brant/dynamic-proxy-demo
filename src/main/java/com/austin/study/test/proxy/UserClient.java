package com.austin.study.test.proxy;

import com.austin.study.test.proxy.impl.UserServiceImpl;
import com.austin.study.test.proxy.impl.UserServiceProxy;

/**
 * @author Austin
 * @since 2019/11/28 17:43   Thu
 */
public class UserClient {

    public static void main(String[] args){
        UserService userServiceImpl = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy(userServiceImpl);
        proxy.select();
        proxy.update();
    }
}
