package com.example.freshmarket.ui.homeactivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freshmarket.apimanger.pojo.Response;

import java.util.List;



public class ViewModelOfHome   extends ViewModel {


    MutableLiveData<List<Response>> allData = new MutableLiveData<>() ;


    MutableLiveData<String> cheak = new MutableLiveData<>()  ;

    RepositoryOfHome repositoryOfHome =new RepositoryOfHome ();

    public ViewModelOfHome() {

        this.allData=repositoryOfHome.allData;
        this.cheak=repositoryOfHome.cheak;
        repositoryOfHome.getData();

    }

}