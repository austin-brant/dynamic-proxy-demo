package com.austin.study.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author Austin
 * @since 2019/11/29 15:18   Fri
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c1 = Class.forName("java.util.Date");
        Class c2 = Date.class;
        Date date = new Date();
        Class c3 = date.getClass();

        if (c1 == c2 && c1 == c3){
            System.out.println("c1、c2、c3 为同一个对象");
            System.out.println(c1);
        }

        Date date1 = (Date) c1.newInstance();
        System.out.println(date1);
        Constructor constructors = c1.getConstructor(long.class);
        Date date2 = (Date) constructors.newInstance(date1.getTime());
        System.out.println(date2);

        Class employeeClass = Class.forName("com.austin.study.test.reflect.Employee");
        System.out.println(employeeClass.getName());
        Constructor[] constructors1 = employeeClass.getConstructors();
        System.out.println(JSONObject.toJSONString(constructors1));
        Constructor[] allConstructors = employeeClass.getDeclaredConstructors();
        System.out.println(JSONObject.toJSONString(allConstructors));
        System.out.println(Modifier.toString(allConstructors[0].getModifiers()));
        for(Class i : allConstructors[0].getParameterTypes()){
            System.out.println(i.getName());
        }

    }
}
