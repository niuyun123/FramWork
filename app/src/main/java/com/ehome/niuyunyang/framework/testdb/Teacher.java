package com.ehome.niuyunyang.framework.testdb;


import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */
public class Teacher {
    @Id
    private Long id;
    private String name;
    private String phoneNum;
    private String teacherCard;
    private String joptitle;//职称
    private int courseId;//对应每个学生的课程
    private Long coursesId;
    @ToMany(referencedJoinProperty = "coursesId")
    private List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getTeacherCard() {
        return teacherCard;
    }

    public void setTeacherCard(String teacherCard) {
        this.teacherCard = teacherCard;
    }

    public String getJoptitle() {
        return joptitle;
    }

    public void setJoptitle(String joptitle) {
        this.joptitle = joptitle;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
