package com.example.lekh.bean2.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lekh.bean2.Adapters.AdapterConnectionsfollowers;
import com.example.lekh.bean2.Adapters.Adapter_Businesses;
import com.example.lekh.bean2.R;

public class FragmentConnectionsFollowersFragment extends Fragment {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_fragment_conections_followers, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_conections_followers, container, false);
        RecyclerView recyclerView = (RecyclerView) retView.findViewById(R.id.rvConectionsFollowers);

        AdapterConnectionsfollowers adapterConnectionsfollowers = new AdapterConnectionsfollowers() { };

        recyclerView.setAdapter(adapterConnectionsfollowers);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return retView;
    }

}
