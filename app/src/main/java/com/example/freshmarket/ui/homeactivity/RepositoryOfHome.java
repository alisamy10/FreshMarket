package com.example.freshmarket.ui.homeactivity;

import androidx.lifecycle.MutableLiveData;
import com.example.freshmarket.apimanger.RetrofitConnection;
import com.example.freshmarket.apimanger.pojo.Response;
import com.example.freshmarket.roomdatabasemanger.MyDataBase;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class RepositoryOfHome {
    public MutableLiveData<List<Response>> allData = new MutableLiveData<>();


    MutableLiveData<String> cheak = new MutableLiveData<>();


    public void getData() {


        RetrofitConnection.getApis().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Response>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(final List<Response> responses) {
                  allData.setValue(responses);
                  cahceProductsToRoom(responses);

            }

            @Override
            public void onError(Throwable e) {
                getAllProductsFromRoom();
            }
        });

    }

    private void getAllProductsFromRoom() {
        Thread thread =new Thread(){
            @Override
            public void run() {
                super.run();
                allData.postValue(MyDataBase.getInstance().productDao().getAllProducts());
            }
        };
        thread.start();
    }

    private void cahceProductsToRoom(final List<Response> responses) {
        Thread thread =new Thread(){
            public void run(){
                super.run();
                MyDataBase.getInstance().productDao().caheProducts(responses);
            }
        };
        thread.start();
    }


    
}
