package com.example.freshmarket.ui.categorydetailsactivity;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.freshmarket.apimanger.pojo.Response;
import java.util.List;

public class ViewModelOfProductDetails  extends ViewModel {

    public MutableLiveData<List<Response>> productDetails = new MutableLiveData<>();

    public MutableLiveData<String> cheak = new MutableLiveData<>();

    RepositoryOfProductDetails repositoryOfProductDetails =new RepositoryOfProductDetails ();

    public ViewModelOfProductDetails() {
        this.productDetails=repositoryOfProductDetails.productDetails;
        this.cheak=repositoryOfProductDetails.cheak;


        repositoryOfProductDetails.getProductDetails("00000");
    }

}
