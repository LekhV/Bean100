package com.example.lekh.bean2.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lekh.bean2.Adapters.AdapterRequests;
import com.example.lekh.bean2.Models.ModelRequests;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityRequests extends AppCompatActivity {

    private RecyclerView myRecycler;
    private List<ModelRequests> modelRequests;
    private AdapterRequests adapterRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle("Requests");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setSupportActionBar(toolbar1);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        myRecycler = (RecyclerView) findViewById(R.id.rvRequests);
        myRecycler.setLayoutManager(new LinearLayoutManager(this));

        modelRequests = new ArrayList<>();
        modelRequests.add(new ModelRequests(R.drawable.one, "Ashton Young", "@hellmyname"));
        modelRequests.add(new ModelRequests(R.drawable.two, "Madison Morrison", "@madison777"));
        modelRequests.add(new ModelRequests(R.drawable.free, "Polly Sims", "@ohmypolly" ));
        adapterRequests = new AdapterRequests(this, modelRequests);

        adapterRequests.SetClickListener(new AdapterRequests.ItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {

                switch (v.getId()) {
                    case R.id.imageViewIconFR:
                        Intent intent = new Intent(ActivityRequests.this, ActivityEventDetail.class);
                        startActivity(intent);
                        break;
                    case R.id.textViewIconNameFR:
                        Intent intent2 = new Intent(ActivityRequests.this, ActivityAboutUs.class);
                        startActivity(intent2);
                        break;

                    case R.id.buttonConfirmFR:
                        Intent intent3 = new Intent(ActivityRequests.this, ActivityEventDetail.class);
                        startActivity(intent3);
                        break;
                    case R.id.buttonDeleteFR:
                        Intent intent4 = new Intent(ActivityRequests.this, ActivityAboutUs.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
        myRecycler.setAdapter(adapterRequests);
    }
}
