package com.ehome.niuyunyang.framework.testEventBus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ehome.niuyunyang.framework.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main13Activity extends AppCompatActivity {

    @BindView(R.id.tvtext)
    TextView tvtext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new MessageInfo("热点","成都热点"));
        tvtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main13Activity.this,Main14Activity.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
   public void receivedMessage(MessageInfo messageInfo){
        Toast.makeText(this, "接受到消息", Toast.LENGTH_SHORT).show();
        tvtext.setText(messageInfo.getTitle()+"   "+messageInfo.getContent());
  }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
