package com.austin.study.test.proxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author Austin
 * @since 2019/11/28 17:50   Thu
 */
public class LogHandler implements InvocationHandler {

    private Object target; // 被代理的对象，实际的方法执行者

    public LogHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args); // 调用 target 的 method 方法
        after();
        return result;
    }

    private void before() {     // 在执行方法之前执行
        System.out.printf("log start time [%s] \n", new Date());
    }

    private void after() {      // 在执行方法之后执行
        System.out.printf("log end time [%s] \n", new Date());
    }
}
