package com.ehome.niuyunyang.framework.testdb;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */
public class Student
{
    @Id
    private Long id;
    private String name;
    private String phoneNum;
    private String cardId;
    private Long classId;
    @ToOne(joinProperty = "classId")
    private StudentClass aStudentClass;
    private Long teachersId;
    @ToMany(referencedJoinProperty = "teachers")
    private List<Teacher> teachers;
    private Long coursesId;
    @ToMany(referencedJoinProperty = "courses")
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

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public StudentClass getaStudentClass() {
        return aStudentClass;
    }

    public void setaStudentClass(StudentClass aStudentClass) {
        this.aStudentClass = aStudentClass;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
