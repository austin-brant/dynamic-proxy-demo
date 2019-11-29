package com.austin.study.test.reflect;

/**
 * @author Austin
 * @since 2019/11/29 15:48   Fri
 */
public class Person {

    public String name; // 姓名 公有
    protected String age;   // 年龄 保护
    private String hobby;   // 爱好   私有

    public Person(String name, String age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }
}
