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

import com.example.lekh.bean2.Adapters.AdapterBusinessesCoupons;
import com.example.lekh.bean2.Adapters.Adapter_Businesses;
import com.example.lekh.bean2.R;


public class BusinessesDetailsCoupons extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_businesses_details_coupons, container, false);
        View retView = inflater.inflate(R.layout.fragment_businesses_details_coupons, container, false);

        RecyclerView recyclerView = (RecyclerView) retView.findViewById(R.id.rvBusinessCoupons);

        AdapterBusinessesCoupons adapterBusinessesCoupons = new AdapterBusinessesCoupons() { };

        recyclerView.setAdapter(adapterBusinessesCoupons);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return retView;
    }

}
