package com.ehome.niuyunyang.framework.testdb;

import android.content.Context;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.baseadapter.CommonAdapter;
import com.ehome.niuyunyang.nyylib.widget.list_grid_view.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */

public class StudentAdapter extends CommonAdapter<Student>{

    public StudentAdapter(Context context, List<Student> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Student student) {
        holder.setText(R.id.tvname,"姓名:"+student.getName()+"\n电话:"+student.getPhoneNum());
        holder.setText(R.id.tvclass,"院系:"+student.getaStudentClass().getFaculty()+"·"+student.getaStudentClass().getClassNum());
        holder.setText(R.id.tvguider,"指导老师:"+student.getaStudentClass().getInstructor().getName()+"("+student.getaStudentClass().getInstructor().getJoptitle()+")"
                        +"\n电话:"+student.getaStudentClass().getInstructor().getPhoneNum());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < student.getTeachers().size(); i++) {
            if (i==0) stringBuffer.append(student.getTeachers().get(i).getName()+"("+student.getTeachers().get(i).getJoptitle()+")");
            else  stringBuffer.append("\n"+student.getTeachers().get(i).getName()+"("+student.getTeachers().get(i).getJoptitle()+")");
        }
        StringBuffer stringBuffer1 = new StringBuffer();
        for (int i = 0; i < student.getCourses().size(); i++) {
            if (i==0){
                stringBuffer.append(student.getCourses().get(i).getName()+"(共"+student.getCourses().get(i).getParts()+"册)");
            }else stringBuffer.append("\n"+student.getCourses().get(i).getName()+"(共"+student.getCourses().get(i).getParts()+"册)");
        }
        holder.setText(R.id.tvteachers,stringBuffer.toString());
        holder.setText(R.id.tvcourses,stringBuffer1.toString());
    }
}
