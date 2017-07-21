package com.ehome.niuyunyang.framework.testcache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ehome.niuyunyang.framework.R;
import com.ehome.niuyunyang.framework.testdb.News;
import com.ehome.niuyunyang.nyylib.util.ACache;
import com.ehome.niuyunyang.nyylib.util.log.LogUtil;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.FindMultiCallback;

import java.util.List;

public class Main11Activity extends AppCompatActivity {

    private ImageView imgCache;
      private Handler handler=new Handler(new Handler.Callback() {
          @Override
          public boolean handleMessage(Message msg) {
              return false;
          }
      });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        final ACache aCache = ACache.get(this, "framwork", false);
        DataSupport.findAllAsync(News.class,true).listen(new FindMultiCallback() {
            @Override
            public <T> void onFinish(List<T> list) {
                aCache.put("news",new Gson().toJson(list));
                LogUtil.json(aCache.getAsString("news"));
            }
        });
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_google_maps_icon);
        //aCache.put("bitmap",bitmap);
        imgCache = (ImageView)findViewById(R.id.ivcacheImag);
        handler.postDelayed(new Runnable() {
              @Override
              public void run() {
                  imgCache.setImageBitmap(bitmap);
              }
          },2000);
        
    }
}
