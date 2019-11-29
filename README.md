## 动态代理分为两种
+ jdk的动态代理
    *  代理对象和目标对象实现了共同的接口
    *  拦截器必须实现InvocationHanlder接口

+ cglib的动态代理
    *  代理对象是目标对象的子类
    *  拦截器必须实现MethodInterceptor接口
    *  hibernate中session.load采用的是cglib实现的