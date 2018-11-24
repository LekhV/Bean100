package com.example.lekh.bean2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.lekh.bean2.Fragments.SignIn;
import com.example.lekh.bean2.Fragments.SignUp;

public class ActivitySignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        SignIn fragmentSignIn = new SignIn();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, fragmentSignIn)
                .commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // toolbar.setTitleTextColor(Color.BLACK);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setTitle(item.getTitle());

        switch (item.getItemId()) {
            case R.id.menuSignIn:
                SignUp fragmentSignUp = new SignUp();
                FragmentManager fragmentManagerSignUp = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionSignUp = fragmentManagerSignUp.beginTransaction();
                fragmentTransactionSignUp.replace(R.id.fragmentContainer, fragmentSignUp);
                fragmentTransactionSignUp.commit();
                return true;

            case R.id.menuSignUp:
                SignIn fragmentSignIn = new SignIn();
                FragmentManager fragmentManagerSignIn = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionSignIn = fragmentManagerSignIn.beginTransaction();
                fragmentTransactionSignIn.replace(R.id.fragmentContainer, fragmentSignIn);
                fragmentTransactionSignIn.commit();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}






