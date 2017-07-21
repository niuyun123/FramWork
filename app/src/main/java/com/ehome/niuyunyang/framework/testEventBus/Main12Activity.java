package com.ehome.niuyunyang.framework.testEventBus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ehome.niuyunyang.framework.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main12Activity extends AppCompatActivity {

    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.bttext)
    Button bttext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

    }

    public void sendmessage(View view) {
        EventBus.getDefault().post(new MessageInfo("天气", "成都天气持续降温"));
        Toast.makeText(this, "发送消息", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    EventBus.getDefault().post(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        startActivity(new Intent(this, Main13Activity.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void update(Integer i) {
        progress.setProgress(i);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
   public void undatetext(MessageInfo info){
       bttext.setText(info.getTitle()+"  "+info.getContent() );
       Toast.makeText(this, "成都热点", Toast.LENGTH_SHORT).show();
   }
    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
