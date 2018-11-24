package com.example.lekh.bean2.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lekh.bean2.R;


public class Recovery extends Fragment {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.recovery, container, false);

        Toolbar toolbar = (Toolbar) retView.findViewById(R.id.toolbar);
        getActivity().setTitle("Password Recovery");

        ((AppCompatActivity)getActivity()).getSupportActionBar();

        final FragmentManager fragmentManager = getFragmentManager();

        Button gotoFragmentOneBtn = (Button)retView.findViewById(R.id.imageButtonSignIn);
        gotoFragmentOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SignIn signIn = new SignIn();

                fragmentTransaction.replace(R.id.fragmentContainer, signIn);

                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return retView;
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

