package com.example.lekh.bean2.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lekh.bean2.ActivityNavigator;
import com.example.lekh.bean2.ActivitySignIn;
import com.example.lekh.bean2.Fragments.ActivityFeedFragment;
import com.example.lekh.bean2.Fragments.BusinessesDetailsCoupons;
import com.example.lekh.bean2.Fragments.BusinessesDetailsInfo;
import com.example.lekh.bean2.Fragments.BusinessesDetailsRating;
import com.example.lekh.bean2.Fragments.FragmentBusinessesDetailsPosts;
import com.example.lekh.bean2.MainActivity;
import com.example.lekh.bean2.R;

public class ActivityBusinessDetaila extends AppCompatActivity implements View.OnClickListener {

    Button buttonPostsB;
    Button buttonInfoB;
    Button buttonOffersB;
    Button buttonRatingB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_detaila);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Businesses Details");

        //toolbar.setTitleTextColor(Color.BLACK);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setSupportActionBar(toolbar); // работает кнопка назад вместо home
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FragmentBusinessesDetailsPosts fragmentFragmentBusinessesDetailsPosts= new FragmentBusinessesDetailsPosts();
        FragmentManager fragmentManagerFragmentBusinessesDetailsPosts = getSupportFragmentManager();
        FragmentTransaction fragmentTransactionFragmentBusinessesDetailsPosts= fragmentManagerFragmentBusinessesDetailsPosts.beginTransaction();
        fragmentTransactionFragmentBusinessesDetailsPosts.add(R.id.fragmentContainerBusiness, fragmentFragmentBusinessesDetailsPosts).commit();


        buttonPostsB = (Button) findViewById(R.id.buttonPostsB);
        buttonInfoB = (Button) findViewById(R.id.buttonInfoB);
        buttonOffersB = (Button) findViewById(R.id.buttonOffersB);
        buttonRatingB = (Button) findViewById(R.id.buttonRatingB);
    }

    @Override
    public void onClick (View view){

       // boolean checked = ((Button) view).isChecked();

        switch (view.getId()) {
            case R.id.buttonPostsB:

                FragmentBusinessesDetailsPosts fragmentFragmentBusinessesDetailsPosts2 = new FragmentBusinessesDetailsPosts();
                FragmentManager fragmentManagerFragmentBusinessesDetailsPosts2= getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentBusinessesDetailsPosts2 = fragmentManagerFragmentBusinessesDetailsPosts2.beginTransaction();
                fragmentTransactionFragmentBusinessesDetailsPosts2.replace(R.id.fragmentContainerBusiness, fragmentFragmentBusinessesDetailsPosts2);
                fragmentTransactionFragmentBusinessesDetailsPosts2.commit();
               // getB.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
           //    buttonPostsB.setEnabled(true);
                buttonPostsB.setTextColor(Color.BLACK);
                buttonInfoB.setTextColor(Color.GRAY);
                buttonOffersB.setTextColor(Color.GRAY);
                buttonRatingB.setTextColor(Color.GRAY);
                break;

            case R.id.buttonInfoB:
                BusinessesDetailsInfo fragmentBusinessesDetailsInfo2 = new BusinessesDetailsInfo();
                FragmentManager fragmentManagerBusinessesDetailsInfo2= getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesDetailsInfo2 = fragmentManagerBusinessesDetailsInfo2.beginTransaction();
                fragmentTransactionBusinessesDetailsInfo2.replace(R.id.fragmentContainerBusiness, fragmentBusinessesDetailsInfo2);
                fragmentTransactionBusinessesDetailsInfo2.commit();
                //buttonInfoB.setEnabled(true);
                buttonPostsB.setTextColor(Color.GRAY);
                buttonInfoB.setTextColor(Color.BLACK);
                buttonOffersB.setTextColor(Color.GRAY);
                buttonRatingB.setTextColor(Color.GRAY);
                break;

            case R.id.buttonOffersB:
                BusinessesDetailsCoupons fragmentBusinessesDetailsCoupons = new BusinessesDetailsCoupons();
                FragmentManager fragmentManagerBusinessesDetailsCoupons = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesDetailsCoupons = fragmentManagerBusinessesDetailsCoupons.beginTransaction();
                fragmentTransactionBusinessesDetailsCoupons.replace(R.id.fragmentContainerBusiness, fragmentBusinessesDetailsCoupons);
                fragmentTransactionBusinessesDetailsCoupons.commit();
             //   buttonOffersB.setEnabled(false);
                buttonPostsB.setTextColor(Color.GRAY);
                buttonInfoB.setTextColor(Color.GRAY);
                buttonOffersB.setTextColor(Color.BLACK);
                buttonRatingB.setTextColor(Color.GRAY);
                break;

            case R.id.buttonRatingB:
                BusinessesDetailsRating fragmentBusinessesDetailsRating = new BusinessesDetailsRating();
                FragmentManager fragmentManagerBusinessesDetailsRating = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesDetailsRating = fragmentManagerBusinessesDetailsRating.beginTransaction();
                fragmentTransactionBusinessesDetailsRating.replace(R.id.fragmentContainerBusiness, fragmentBusinessesDetailsRating);
                fragmentTransactionBusinessesDetailsRating.commit();
                //   buttonOffersB.setEnabled(false);
                buttonPostsB.setTextColor(Color.GRAY);
                buttonInfoB.setTextColor(Color.GRAY);
                buttonOffersB.setTextColor(Color.GRAY);
                buttonRatingB.setTextColor(Color.BLACK);
                break;
            default:
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_business_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuBusinessesDetailP:
                Intent intent = new Intent(ActivityBusinessDetaila.this, ActivityNewBusinesss.class);
                startActivity(intent);
                return true;
            case R.id.menuBusinessesM:
                Intent intent2 = new Intent(ActivityBusinessDetaila.this, ActivityNewBusinesss.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
