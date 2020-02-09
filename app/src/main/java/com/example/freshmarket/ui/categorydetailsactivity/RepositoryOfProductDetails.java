package com.example.freshmarket.ui.categorydetailsactivity;

import androidx.lifecycle.MutableLiveData;

import com.example.freshmarket.apimanger.RetrofitConnection;
import com.example.freshmarket.apimanger.pojo.Response;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RepositoryOfProductDetails {

    public MutableLiveData<List<Response>> productDetails = new MutableLiveData<>();

    public MutableLiveData<String> cheak = new MutableLiveData<>();


    public void getProductDetails(String id) {

        RetrofitConnection.getApis().getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Response>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Response> responses) {
                         productDetails.setValue(responses);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });




    }


}
