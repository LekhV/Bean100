package com.example.lekh.bean2.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.lekh.bean2.R;

public class ActivityAddPost extends AppCompatActivity implements View.OnClickListener{

    Button BtnAddPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        BtnAddPost = findViewById(R.id.buttonAddAtach);
        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        setTitle("Add Post");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setSupportActionBar(toolbar1);
        toolbar1.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddAtach:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                photoPickerIntent.setType("image/*");
                startActivity(photoPickerIntent);
                break;
        }
    }
}

