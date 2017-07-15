package com.ehome.niuyunyang.framework.testJson;

/**
 * Created by NewYyoung on 2017/7/7.
 * version 2.8
 */

public class Student {
    private String name;
    private String number;
    private int age;
    private String nickName;
    private String addr;

    public Student(String name, String number, int age, String nickName, String addr) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.nickName = nickName;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
