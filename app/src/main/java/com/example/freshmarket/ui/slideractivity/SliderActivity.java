package com.example.freshmarket.ui.slideractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.freshmarket.R;
import com.example.freshmarket.adapter.ViewPagerAdapter;
import com.example.freshmarket.model.ModelpagerViewe;
import com.example.freshmarket.ui.homeactivity.HomeActivity;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private ArrayList<ModelpagerViewe> mlist;
    private LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    private ViewPagerAdapter viewPagerAdapter;
    private TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        initView();
        fillDumyData();


        makeDots();


    }

    private void makeDots() {
        dotscount = viewPagerAdapter.getCount();

        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

                Toast.makeText(SliderActivity.this, "" + position, Toast.LENGTH_SHORT).show();

                if (position == dotscount - 1) {
                    skip.setVisibility(View.GONE);
                    goToHome();

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void fillDumyData() {
        mlist = new ArrayList<>();

        mlist.add(new ModelpagerViewe(R.drawable.logo, "Mauris pharetra nisl eget", "Mauris pharetra nisl eget Mauris pharetra nisl eget Mauris pharetra nisl eget"));
        mlist.add(new ModelpagerViewe(R.drawable.logo, "Mauris pharetra nisl eget", "Mauris pharetra nisl eget Mauris pharetra nisl eget Mauris pharetra nisl eget"));
        mlist.add(new ModelpagerViewe(R.drawable.logo, "Mauris pharetra nisl eget", "Mauris pharetra nisl eget Mauris pharetra nisl eget Mauris pharetra nisl eget"));
        mlist.add(new ModelpagerViewe(R.drawable.logo, "Mauris pharetra nisl eget", "Mauris pharetra nisl eget Mauris pharetra nisl eget Mauris pharetra nisl eget"));

        viewPagerAdapter = new ViewPagerAdapter(mlist, this);
        viewPager.setAdapter(viewPagerAdapter);

    }

    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        sliderDotspanel = findViewById(R.id.SliderDots);
        skip = findViewById(R.id.skipslide);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.skipslide:
                goToHome();
                break;
            default:
                break;
        }
    }

    private void goToHome() {
      startActivity(new Intent(this , HomeActivity.class));
      finish();
    }
}
