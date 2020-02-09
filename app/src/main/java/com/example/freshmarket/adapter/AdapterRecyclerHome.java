package com.example.freshmarket.adapter;

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

public class AdapterRecyclerHome extends RecyclerView.Adapter<AdapterRecyclerHome.HomeViewHolder> {

    private List<Response> homeList = new ArrayList<>();


    public interface  OnItemClickListner{
        void onItemClick(int pos, Response response);
    }

    OnItemClickListner onItemClickListener;

    public void setOnItemClickListener(OnItemClickListner onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homeitem,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, final int position) {
        Glide.with(holder.itemView).load(homeList.get(position).getCategory_img()).into(holder.imageView);
        holder.textView.setText(homeList.get(position).getName());
        if(onItemClickListener!=null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,homeList.get(position));
                }
            });

    }




    @Override
    public int getItemCount() {

        return homeList == null ? 0 : homeList.size();
    }

    public void setList(List<Response> homeList) {
        this.homeList = homeList;
        notifyDataSetChanged();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView ;
        public TextView textView;
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_poster);
            textView=itemView.findViewById(R.id.productname);
        }
    }


}
