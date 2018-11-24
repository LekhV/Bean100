package com.example.lekh.bean2.Fragments;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lekh.bean2.Adapters.AdapterEvents;
import com.example.lekh.bean2.Adapters.AdapterPhoto;
import com.example.lekh.bean2.Adapters.AdapterPhotoPhoto;
import com.example.lekh.bean2.Models.CreateListPhoto;
import com.example.lekh.bean2.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


public class PhotosFragment extends Fragment {

    public ArrayList<CreateListPhoto> createLists;

    public PhotosFragment() {
    }
    @Override
    public void onCreate( Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_photos, container, false);
        View retView = inflater.inflate(R.layout.fragment_photos, container, false);
        getActivity().setTitle("Photos");
        //getActivity().getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        Toolbar toolbar = (Toolbar) retView.findViewById(R.id.toolbar);
        RecyclerView recyclerViewPhoto = (RecyclerView) retView.findViewById(R.id.rvFragmentPhoto);
        createLists = this.getActivity().getIntent().getParcelableArrayListExtra("BookStatus");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 2); // количество столбиков
        recyclerViewPhoto.setLayoutManager(layoutManager);
        // создаем адаптер
        AdapterPhotoPhoto adapterPhotoPhoto = new AdapterPhotoPhoto(getActivity().getApplicationContext(), createLists);
        // устанавливаем для списка адаптер
        recyclerViewPhoto.setAdapter(adapterPhotoPhoto);


        return retView;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_photo_comment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }
}


