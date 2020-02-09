package com.example.freshmarket.roomdatabasemanger;

import android.content.Context;


import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.freshmarket.apimanger.pojo.Response;
import com.example.freshmarket.roomdatabasemanger.dao.ProductDao;


@Database(entities = {Response.class},version = 1,exportSchema = false)
public abstract class MyDataBase  extends RoomDatabase {
    public static final String DB_NAME = "posts database";
    private static MyDataBase dataBase;

    public abstract ProductDao productDao();


    public static void init(Context context) {
        if (dataBase == null) {
            //initialize
            dataBase = Room.databaseBuilder(context,
                    MyDataBase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();

        }
    }
    public static MyDataBase  getInstance(){
        return dataBase;
    }
}