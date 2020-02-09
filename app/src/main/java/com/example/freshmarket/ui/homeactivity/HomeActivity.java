package com.example.freshmarket.ui.homeactivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import com.example.freshmarket.R;
import com.example.freshmarket.adapter.AdapterRecyclerHome;
import com.example.freshmarket.adapter.ViewPagerHomeAdapter;
import com.example.freshmarket.apimanger.pojo.Response;
import com.example.freshmarket.model.ModelpagerViewe;
import com.example.freshmarket.ui.categorydetailsactivity.ProductDetailsActivity;

import android.view.MenuItem;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private ViewPager viewPager;
    private ArrayList<ModelpagerViewe> mlist;
    private LinearLayout sliderDotspanel;
    private Toolbar toolbar;
    private int dotscount;
    private ImageView[] dots;
    private ViewPagerHomeAdapter viewPagerAdapter;
    private ViewModelOfHome viewModel  ;
    private AdapterRecyclerHome adapter ;
    private RecyclerView recyclerView;
    private List <Response> responseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();

        fillDumyData();

        makeDots();

        this.getWindow().setStatusBarColor(0x000000);


        obsrveToLiveData();



    }
    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        adapter=new AdapterRecyclerHome();
        viewPager =  findViewById(R.id.viewpager);
        sliderDotspanel = findViewById(R.id.SliderDots);
        recyclerView=findViewById(R.id.rechome);
        recyclerView.setLayoutManager(new GridLayoutManager(HomeActivity.this,2));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new AdapterRecyclerHome.OnItemClickListner() {
            @Override
            public void onItemClick(int pos, Response response) {
                Intent intent = new Intent(HomeActivity.this, ProductDetailsActivity.class);
                intent.putExtra("id",response.getId());
                intent.putExtra("img",response.getCategory_img());
                startActivity(intent);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_name);



    }








    private void obsrveToLiveData() {
        viewModel = ViewModelProviders.of(this).get(ViewModelOfHome.class);

        viewModel.allData.observe(this, new Observer<List<Response>>() {
            @Override
            public void onChanged(List<Response> responses) {
                adapter.setList(responses);
                responseList=responses;


            }
        });


        viewModel.cheak.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(HomeActivity.this, "error"+s, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void makeDots() {
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];
        for(int i = 0; i < dotscount; i++){
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
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void fillDumyData() {
        mlist=new ArrayList<>();
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        mlist.add(new ModelpagerViewe(R.drawable.logohome));
        viewPagerAdapter = new ViewPagerHomeAdapter(mlist,this);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);




        SearchManager searchManager =
                (SearchManager) getSystemService(this.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
       // EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
       // searchEditText.setTextColor(getResources().getColor(R.color.colorAccent));
        searchView.setOnQueryTextListener(this);

        return true;
    }




   /* @Override
    public void onBackPressed () {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_addToCard:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        newText = newText.toLowerCase();

        List<Response> responses = new ArrayList<>();

        //progressBar.setVisibility(View.VISIBLE);
        for (Response response : responseList) {
            String name = response.getName().toLowerCase();

            if (name.contains(newText)) {

                //progressBar.setVisibility(View.GONE);
                responses.add(response);
            }
        }
        adapter.setList(responses);
        return true;
    }

}
