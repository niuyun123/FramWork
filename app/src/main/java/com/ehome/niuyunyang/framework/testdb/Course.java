package com.ehome.niuyunyang.framework.testdb;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */
public class Course {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String courseId;
    private int parts;//几册
    private boolean isCompulsory;//是否必修
    private Long teachersId;//课程关联老师的主外键
    @ToMany(referencedJoinProperty = "teachersId")
    private List<Teacher> teachers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }


    public boolean isCompulsory() {
        return isCompulsory;
    }

    public void setCompulsory(boolean compulsory) {
        isCompulsory = compulsory;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
