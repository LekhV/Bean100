package com.example.lekh.bean2.Fragments;

import android.os.Bundle;
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
import com.example.lekh.bean2.Adapters.AdapterConnectionsfollowing;
import com.example.lekh.bean2.R;

public class FragmentConnectionsFollowingFragment extends Fragment {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fragment_conections_following, container, false);

        View retView = inflater.inflate(R.layout.fragment_fragment_conections_following, container, false);
        RecyclerView recyclerView = (RecyclerView) retView.findViewById(R.id.rvConectionsFollowing);

        AdapterConnectionsfollowing adapterConnectionsfollowing = new AdapterConnectionsfollowing() { };

        recyclerView.setAdapter(adapterConnectionsfollowing);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return retView;
    }


}
