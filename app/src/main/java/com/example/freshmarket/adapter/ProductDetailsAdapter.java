package com.example.freshmarket.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.freshmarket.R;
import com.example.freshmarket.apimanger.pojo.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ProductDetailsViewHolder> {

    private List<Response.ProductsBean> productDetails = new ArrayList<>();
    private boolean isDone=false;


    @NonNull
    @Override
    public ProductDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductDetailsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_filter_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductDetailsViewHolder holder, int position) {
        Glide.with(holder.itemView).load(productDetails.get(position).getProduct_img()).into(holder.img);

        holder.title.setText(productDetails.get(position).getName());
        holder.quantity.setText(productDetails.get(position).getWeight());
        holder.price.setText(productDetails.get(position).getPrice());




        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int id = (int)holder.img.getTag();


                if(isDone) {
                    holder.add.setImageResource(R.drawable.ic_done_name);
                    isDone=!isDone;
                }
                else
                {
                    holder.add.setImageResource(R.drawable.ic_search_name);
                    isDone=!isDone;
                }

            }
        });

    }

    @Override
    public int getItemCount() {

        return productDetails == null ? 0 : productDetails.size();
    }

    public void setList(List<Response.ProductsBean> productDetails) {
        this.productDetails = productDetails;
        notifyDataSetChanged();
    }

    public class ProductDetailsViewHolder extends RecyclerView.ViewHolder {
        public ImageView img,add;
        public TextView title, quantity, price;

        public ProductDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_poster);
            add=itemView.findViewById(R.id.add);
            title = itemView.findViewById(R.id.product_category_title);
            quantity = itemView.findViewById(R.id.product_category_quantity);
            price = itemView.findViewById(R.id.product_category_price);
        }
    }
}