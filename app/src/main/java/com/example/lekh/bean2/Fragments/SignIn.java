package com.example.lekh.bean2.Fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lekh.bean2.ActivityNavigator;
import com.example.lekh.bean2.R;


public class  SignIn extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.sign_in, container, false);

        getActivity().setTitle("Sign In");
        Toolbar toolbar = (Toolbar) retView.findViewById(R.id.toolbar);

        TextView textViewgotoFragmentSignUp = retView.findViewById(R.id.textBtnViewPassRec);
        textViewgotoFragmentSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Recovery fragmentRecovery = new Recovery();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fragmentContainer, fragmentRecovery);
                fragmentTransaction2.commit();

            }
       });

        Button buttonNav = retView.findViewById(R.id.buttonSignIn);
        buttonNav.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getContext(), ActivityNavigator.class);
                startActivity(intent);

                //Intent intent = new Intent(SignIn.this, ActivityNavigator.class);
               // startActivity(intent);
            }
        });

        return retView;

    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sign_in, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:

                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }
}

