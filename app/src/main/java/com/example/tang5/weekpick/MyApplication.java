package com.example.tang5.weekpick;

import android.app.Application;

import com.lzy.okgo.OkGo;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
    }
}
