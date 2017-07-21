package com.ehome.niuyunyang.framework.testEventBus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ehome.niuyunyang.framework.R;

import org.greenrobot.eventbus.EventBus;

public class Main14Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        EventBus.getDefault().post(new MessageInfo("重启","重启热点"));
    }
}
