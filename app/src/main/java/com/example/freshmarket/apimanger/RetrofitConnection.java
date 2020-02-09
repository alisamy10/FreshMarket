package com.example.freshmarket.apimanger;

import com.example.freshmarket.helper.Helper;

import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitConnection {
    private static Retrofit retrofit;
    private static Retrofit getInstance(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Helper.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static CallInterface getApis(){
        return getInstance().create(CallInterface.class);
    }
}



