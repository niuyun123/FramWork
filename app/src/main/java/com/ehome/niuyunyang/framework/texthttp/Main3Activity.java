package com.ehome.niuyunyang.framework.texthttp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.nyylib.http.OkHttpUtils;
import com.ehome.niuyunyang.nyylib.http.callback.BitmapCallback;

import okhttp3.Call;

public class Main3Activity extends AppCompatActivity {
    private Handler hander=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
           img.setImageBitmap((Bitmap) msg.obj);
            return false;
        }
    });
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        img = (ImageView) findViewById(R.id.imagtest);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpUtils.get().url("http://avatar.csdn.net/F/F/5/1_lmj623565791.jpg").build().execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e("Main3Activity"+":"+"onError","======YUNYANG====="+"下载图片失败");

                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        Message message = hander.obtainMessage();
                        message.obj=response;
                        hander.sendMessage(message);
                    }
                });
            }
        });
    }
}
