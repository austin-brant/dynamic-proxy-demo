package com.austin.study.test.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * @author Austin
 * @since 2019/11/29 11:42   Fri
 */
// 回调过滤器: 在CGLib回调时可以设置对不同方法执行不同的回调逻辑，或者根本不执行回调。
public class DaoFilter implements CallbackFilter {

    public int accept(Method method) {
        if ("select".equals(method.getName())) {
            return 0;   // Callback 列表第1个拦截器
        }
        return 1;   // Callback 列表第2个拦截器，return 2 则为第3个，以此类推
    }

}
