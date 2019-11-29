package com.austin.study.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.austin.study.test.proxy.impl.LogHandler;
import com.austin.study.test.proxy.impl.ProxyUtils;
import com.austin.study.test.proxy.impl.StudentSeviceImpl;
import com.austin.study.test.proxy.impl.UserServiceImpl;

/**
 * @author Austin
 * @since 2019/11/28 17:53   Thu
 */
public class UserClientJdkDynamic {

    public static void main(String[] args) {
        // 0. 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名
        // System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 1. 创建被代理的对象，UserService接口的实现类
        UserServiceImpl userService = new UserServiceImpl();

        UserService studentSevice = new StudentSeviceImpl();

        // 2. 获取所有接口的Class，这里的UserServiceImpl只实现了一个接口UserService
        Class[] interfaces = userService.getClass().getInterfaces();

        // 3. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        //  这里创建的是一个自定义的日志处理器，须传入实际的执行对象 userService
        InvocationHandler logHandler = new LogHandler(studentSevice);


    /*
      4.根据上面提供的信息，创建代理对象 在这个过程中，
          a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
          b.然后根据相应的字节码转换成对应的class，
          c.然后调用newInstance()创建代理实例
    */
        UserService service = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                interfaces, logHandler);



        service.select();
        service.update();

        System.out.println(Proxy.getInvocationHandler(service));
        System.out.println(Proxy.getProxyClass(userService.getClass().getClassLoader(), interfaces));
        System.out.println(Proxy.isProxyClass(studentSevice.getClass()));
        System.out.println(Proxy.isProxyClass(service.getClass()));
        System.out.println(Proxy.isProxyClass(logHandler.getClass()));

        // 保存JDK动态代理生成的代理类，类名保存为 UserServiceProxy
        ProxyUtils.generateClassFile(userService.getClass(), "UserServiceProxy2");

    }
}
