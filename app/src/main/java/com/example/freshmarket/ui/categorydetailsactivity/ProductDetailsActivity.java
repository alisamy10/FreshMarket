package com.example.freshmarket.ui.categorydetailsactivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.freshmarket.R;
import com.example.freshmarket.adapter.ProductDetailsAdapter;
import com.example.freshmarket.apimanger.pojo.Response;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    RecyclerView recyclerViewProductDetails;
    ProductDetailsAdapter adapter;
    ViewModelOfProductDetails viewModel;
    private ImageView detailsImgProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);



        viewModel = ViewModelProviders.of(this).get(ViewModelOfProductDetails.class);



        intiView();
        Glide.with(this).load(getIntent().getStringExtra("img")).into(detailsImgProduct);


        observeToLiveData();


    }



    private void observeToLiveData() {
        viewModel.productDetails.observe(this, new Observer<List<Response>>() {
            @Override
            public void onChanged(List<Response> responses) {
                adapter.setList(responses.get(Integer.parseInt(getIntent().getStringExtra("id")) - 1).getProducts());
            }
        });


    }


    protected void intiView() {
        detailsImgProduct = findViewById(R.id.product_details_img);
        tabLayout = findViewById(R.id.tabLayout_product_details);
        tabLayout.addTab(tabLayout.newTab().setText("Meat"));
        tabLayout.addTab(tabLayout.newTab().setText("Fish"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter = new ProductDetailsAdapter();
        recyclerViewProductDetails = findViewById(R.id.recproductdetails);
        recyclerViewProductDetails.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerViewProductDetails.setAdapter(adapter);
    }

}

