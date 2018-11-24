package com.example.lekh.bean2.Activitys;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lekh.bean2.Adapters.SliderAdapterPostDetails;
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityPostsDetails extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout indicator;
    private List<ModelSlider> modelSliderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_details);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle("Post Details");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setSupportActionBar(toolbar1);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });


        viewPager=(ViewPager)findViewById(R.id.viewPager);
        indicator=(TabLayout)findViewById(R.id.indicator);

        modelSliderList = new ArrayList<>();
        modelSliderList.add(new ModelSlider (R.drawable.imageevents));
        modelSliderList.add(new ModelSlider (R.drawable.makarons));
        modelSliderList.add(new ModelSlider (R.drawable.imageevents));


        viewPager.setAdapter(new SliderAdapterPostDetails(this, modelSliderList));
        indicator.setupWithViewPager(viewPager, true);

    }


}
