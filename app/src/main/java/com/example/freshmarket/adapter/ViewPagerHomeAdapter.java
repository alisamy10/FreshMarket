package com.example.freshmarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.freshmarket.R;
import com.example.freshmarket.model.ModelpagerViewe;

import java.util.ArrayList;

public class ViewPagerHomeAdapter extends PagerAdapter {

    private ArrayList<ModelpagerViewe> mlist;
    private Context context;
    private LayoutInflater layoutInflater;
    public ViewPagerHomeAdapter(ArrayList<ModelpagerViewe> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pagerviewitemhome, null);
        ImageView imageView = view.findViewById(R.id.imageViewHome);
        imageView.setImageResource(mlist.get(position).getImg());

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}

