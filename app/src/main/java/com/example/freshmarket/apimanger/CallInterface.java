package com.example.freshmarket.apimanger;

import com.example.freshmarket.apimanger.pojo.Response;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface CallInterface {

    @GET("categories")
    Single<List<Response>> getAll();



}
