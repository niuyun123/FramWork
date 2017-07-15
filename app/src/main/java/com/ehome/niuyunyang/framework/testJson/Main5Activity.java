package com.ehome.niuyunyang.framework.testJson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.niuyunyang.framework.R;
import com.google.gson.Gson;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main5Activity extends AppCompatActivity {

    Student student;
    private TextView content;
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);

        student = new Student("张三", "1581716113", 24, "小张", "盛安街299号-717");
        content = (TextView) findViewById(R.id.content);
        findViewById(R.id.tojson).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                json = new Gson().toJson(student);
                content.setText(json);
            }
        });
        findViewById(R.id.toObj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Gson().fromJson(json, Student.class);
                content.setText(student.toString());
            }
        });
    }


    @OnClick({R.id.testButton, R.id.testButton2, R.id.testButton3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.testButton:
                Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
                break;
            case R.id.testButton2:
                Toast.makeText(this, "Hello China", Toast.LENGTH_SHORT).show();
                break;
            case R.id.testButton3:
                Toast.makeText(this, "Hello SiChuan", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
