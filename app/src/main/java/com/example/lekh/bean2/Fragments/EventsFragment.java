package com.example.lekh.bean2.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lekh.bean2.Activitys.ActivityAboutUs;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Adapters.AdapterEvents;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;



public class EventsFragment extends Fragment {

    FragmentActivity mActivity;
    AdapterEvents adapterEvents;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentActivity) activity;
        setRetainInstance(true);
    }

    public EventsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_events, container, false);
        View retView = inflater.inflate(R.layout.fragment_events, container, false);
        RecyclerView recyclerView = (RecyclerView) retView.findViewById(R.id.rvEvents);
        getActivity().setTitle("Events");

        adapterEvents = new AdapterEvents() { };

        recyclerView.setAdapter(adapterEvents);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapterEvents.SetOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {


                //Intent intent = new Intent(getContext(), ActivityEventDetail.class);
                //startActivity(intent);

               // int position = getAdapterPosition();
                //if (position != RecyclerView.NO_POSITION) {
                    switch (v.getId()) {
                        case R.id.imageViewPostEvent:
                            Intent intent = new Intent(getContext(), ActivityEventDetail.class);
                            startActivity(intent);
                            break;
                        case R.id.imageViewMapGreen:
                            Intent intent2 = new Intent(getContext(), ActivityAboutUs.class);
                            startActivity(intent2);
                            break;

                        case R.id.textViewNameEvent:
                            Intent intent3 = new Intent(getContext(), ActivityEventDetail.class);
                            startActivity(intent3);
                            break;
            }
            }
        });

        return retView;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_event, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}