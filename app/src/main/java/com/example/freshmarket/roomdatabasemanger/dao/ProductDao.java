package com.example.freshmarket.roomdatabasemanger.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.freshmarket.apimanger.pojo.Response;

import java.util.List;

@Dao
public interface ProductDao {

    @Query("select  id , name , category_img from Response ")
    List<Response> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void caheProducts(List<Response> Response);

}
