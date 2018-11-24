package com.example.lekh.bean2.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lekh.bean2.R;


public class SignUp extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.sign_up, container, false);
        getActivity().setTitle("Sign Up");

       /* Button buttonSignUp = retView.findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ActivityFeedFragment fragmentActivityFeedFragment = new ActivityFeedFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(R.id.fragmentContainer, fragmentActivityFeedFragment);
                fragmentTransaction2.commit();

            }
        });*/

        return retView;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_sign_up, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case android.R.id.home:
                SignIn fragmentSignIn = new SignIn();
                FragmentManager fragmentManagerSignIn = getFragmentManager();
                FragmentTransaction fragmentTransactionSignIn = fragmentManagerSignIn.beginTransaction();
                fragmentTransactionSignIn.replace(R.id.fragmentContainer, fragmentSignIn);
                fragmentTransactionSignIn.commit();
                return true;

            default:return super.onOptionsItemSelected(item);
        }
    }
}