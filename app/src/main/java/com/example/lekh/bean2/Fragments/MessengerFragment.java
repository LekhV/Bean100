package com.example.lekh.bean2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lekh.bean2.Adapters.AdapterMessenger;
import com.example.lekh.bean2.Adapters.Adapter_Businesses;
import com.example.lekh.bean2.R;


public class MessengerFragment extends Fragment {


    public MessengerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             // return inflater.inflate(R.layout.fragment_messenger, container, false);
        View retView = inflater.inflate(R.layout.fragment_messenger, container, false);
        RecyclerView recyclerView = (RecyclerView) retView.findViewById(R.id.rvMessenger);

        AdapterMessenger adapterMessenger = new AdapterMessenger() { };

        recyclerView.setAdapter(adapterMessenger);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return retView;
    }
}
