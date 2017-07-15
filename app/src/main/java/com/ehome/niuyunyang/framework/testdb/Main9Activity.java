package com.ehome.niuyunyang.framework.testdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.util.log.LogUtil;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main9Activity extends AppCompatActivity {

    @BindView(R.id.list)
    ListView list;
    private List<Student> students=new ArrayList<>();
    private boolean fromDb=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        ButterKnife.bind(this);
        if (fromDb){

        }else  initData();

    }

    private void findData() {
        for (int i = 0; i < 2; i++) {
            Student student = DataSupport.find(Student.class, i,true);
            LogUtil.json(student);
            Teacher teacher = DataSupport.find(Teacher.class, i, true);
            LogUtil.json(teacher);
            students.add(student);

        }
    }

    private void initData() {
        Student student;
        for (int i = 10; i < 50; i++) {
            student = new Student();
            student.setCardId("2012083412"+i);
            student.setName("牛小"+i);
            student.setPhoneNum("152817161"+i);
                StudentClass aStudentClass = new StudentClass();
                aStudentClass.setClassNum("信息系统与信息管理12班");
                aStudentClass.setFaculty("数学与信息学院");
                    Teacher teacher = new Teacher();
                    teacher.setPhoneNum("13910733521");
                    teacher.setName("潘大致");
                    teacher.setJoptitle("教授");
                    teacher.setTeacherCard("199020543658");
                            List<Course> courses=new ArrayList<>();
                            Course course = new Course();
                            course.setName("高等数学");
                            course.setCompulsory(true);
                            course.setCourseId("195808341210");
                            course.setParts(2);
                            Course course1 = new Course();
                            course1.setName("线性代数");
                            course1.setCompulsory(true);
                            course1.setCourseId("195808341211");
                            course1.setParts(2);
                            Course course2 = new Course();
                            course2.setName("概率论");
                            course2.setCompulsory(true);
                            course2.setCourseId("195808341212");
                            course2.setParts(2);
                            courses.add(course);
                            courses.add(course1);
                            courses.add(course2);
                    teacher.setCourses(courses);
                aStudentClass.setInstructor(teacher);
            student.setaStudentClass(aStudentClass);
                    List<Teacher>  teachers=new ArrayList<>();
                    Teacher teacher1 = new Teacher();
                    teacher1.setPhoneNum("13910733522");
                    teacher1.setName("高大鹏");
                    teacher1.setJoptitle("教授");
                    teacher1.setTeacherCard("199020543659");
                    Teacher teacher2 = new Teacher();
                    teacher2.setPhoneNum("13910733523");
                    teacher2.setName("沈兴吉");
                    teacher2.setJoptitle("博士");
                    teacher2.setTeacherCard("199020543650");
                    teachers.add(teacher2);
                    Teacher teacher3 = new Teacher();
                    teacher3.setPhoneNum("13910733520");
                    teacher3.setName("张海军");
                    teacher3.setJoptitle("博士");
                    teacher3.setTeacherCard("199020543651");
                    teachers.add(teacher3);
            student.setTeachers(teachers);
                    Course course3 = new Course();
                    course3.setName("新概念英语");
                    course3.setCompulsory(true);
                    course3.setCourseId("195808341213");
                    course3.setParts(4);
                    courses.add(course3);
                    Course course4 = new Course();
                    course4.setName("管理学");
                    course4.setCompulsory(true);
                    course4.setCourseId("195808341213");
                    course4.setParts(1);
                    courses.add(course4);
            student.setCourses(courses);
            students.add(student);
        }

    }
}
