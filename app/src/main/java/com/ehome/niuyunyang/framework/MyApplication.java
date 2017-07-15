package com.ehome.niuyunyang.framework;

import android.database.sqlite.SQLiteDatabase;

import com.ehome.niuyunyang.nyylib.http.OkHttpUtils;
import com.ehome.niuyunyang.nyylib.http.log.LoggerInterceptor;
import com.ehome.niuyunyang.nyylib.util.log.LogUtil;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by NewYyoung on 2017/7/14.
 * version 2.8
 */

public class MyApplication extends LitePalApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
        LogUtil.d("程序已启动!!!!!!");
        SQLiteDatabase database = Connector.getDatabase();
    }
}
