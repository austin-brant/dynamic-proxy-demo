package com.austin.study.test.cglib;

/**
 * @author Austin
 * @since 2019/11/28 19:18   Thu
 */
public class CglibClient {

    public static void main(String[] args){
        //目标对象
        UserDao userDao = new UserDao();
        LogInterceptor interceptor = new LogInterceptor(userDao);
        // 代理对象，调用cglib系统方法自动生成
        // 注意：代理类是目标类的子类。
        UserDao proxy = (UserDao) interceptor.createProxy();
        proxy.select();
        proxy.update();
    }
}
