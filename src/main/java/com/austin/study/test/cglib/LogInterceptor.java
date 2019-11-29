package com.austin.study.test.cglib;

import java.lang.reflect.Method;
import java.util.Date;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 动态代理拦截类
 *
 * @author Austin
 * @since 2019/11/28 19:15   Thu
 */
public class LogInterceptor implements MethodInterceptor {

    private Object target;  //目标类

    public LogInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 返回代理对象
     * 具体实现，暂时先不追究。
     */
    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);  // 回调函数  拦截器
        // 设置代理对象的父类,可以看到代理对象是目标对象的子类。所以这个接口类就可以省略了
        enhancer.setSuperclass(this.target.getClass());
        //        enhancer.setCallbackFilter(new DaoFilter());
        return enhancer.create();
    }

    /**
     * @param object      表示要进行增强的对象
     * @param method      表示拦截的方法
     * @param objects     数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     *
     * @return 执行结果
     *
     * @throws Throwable
     */
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        // 注意这里是调用 invokeSuper 而不是 invoke，否则死循环，
        // methodProxy.invokesuper执行的是原始类的方法，method.invoke执行的是子类的方法
        Object result = methodProxy.invokeSuper(object, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }
}
