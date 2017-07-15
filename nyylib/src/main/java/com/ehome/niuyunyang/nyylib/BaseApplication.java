package com.ehome.niuyunyang.nyylib;

import android.app.Application;

import com.ehome.niuyunyang.nyylib.http.OkHttpUtils;
import com.ehome.niuyunyang.nyylib.http.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by NewYyoung on 2017/7/7.
 * version 2.8
 */

public class BaseApplication extends Application{
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

    }
}
