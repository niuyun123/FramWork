package com.ehome.niuyunyang.framework.testdb;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */
public class StudentClass {
    @Id
    private Long id;
    @NotNull
    private String faculty;//院
    @NotNull
    private String classNum;//班级号
    private Long instructorId;//
    @ToOne(joinProperty = "instructorId" )
    private Teacher instructor;//教导员
    @Transient
    private List<Student> students;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }


    public Teacher getInstructor() {
        return instructor;
    }

    public void setInstructor(Teacher instructor) {
        this.instructor = instructor;
    }
}
