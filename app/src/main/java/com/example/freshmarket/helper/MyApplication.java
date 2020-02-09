package com.example.freshmarket.helper;

import android.app.Application;

import com.example.freshmarket.roomdatabasemanger.MyDataBase;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyDataBase.init(this);
    }
}
