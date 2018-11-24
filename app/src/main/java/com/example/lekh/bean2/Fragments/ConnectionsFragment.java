package com.example.lekh.bean2.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lekh.bean2.Activitys.ActivityRequests;
import com.example.lekh.bean2.R;


public class ConnectionsFragment extends Fragment {

    Button buttonFollowing;
    Button buttonFollowers;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_connections, container, false);
        View retView = inflater.inflate(R.layout.fragment_connections, container, false);

        getActivity().setTitle("Connections");
        Button btnFollowrequests = retView.findViewById(R.id.buttonFollowrequests);
        btnFollowrequests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityRequests.class);
                startActivity(intent);

            }
        });

        FragmentConnectionsFollowingFragment fragmentFragmentConnectionsFollowingFragment = new FragmentConnectionsFollowingFragment();
        FragmentManager fragmentManagerFragmentConnectionsFollowingFragment= getFragmentManager();
        FragmentTransaction fragmentTransactionFragmentConnectionsFollowingFragment= fragmentManagerFragmentConnectionsFollowingFragment.beginTransaction();
        fragmentTransactionFragmentConnectionsFollowingFragment.add(R.id.fragmentContainerConnections, fragmentFragmentConnectionsFollowingFragment).commit();


        buttonFollowing = (Button) retView.findViewById(R.id.buttonFollowing);
        buttonFollowing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentConnectionsFollowingFragment fragmentFragmentConnectionsFollowingFragment2 = new FragmentConnectionsFollowingFragment();
                FragmentManager fragmentManagerFragmentConnectionsFollowingFragment2 = getFragmentManager();
                FragmentTransaction fragmentTransactionFragmentConnectionsFollowingFragment2= fragmentManagerFragmentConnectionsFollowingFragment2.beginTransaction();
                fragmentTransactionFragmentConnectionsFollowingFragment2.replace(R.id.fragmentContainerConnections, fragmentFragmentConnectionsFollowingFragment2);
                fragmentTransactionFragmentConnectionsFollowingFragment2.commit();
                buttonFollowing.setTextColor(Color.BLACK);
                buttonFollowers.setTextColor(Color.GRAY);
            }
        });

        buttonFollowers = (Button) retView.findViewById(R.id.buttonFollowers);
        buttonFollowers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentConnectionsFollowersFragment fragmentFragmentConnectionsFollowersFragment = new FragmentConnectionsFollowersFragment();
                FragmentManager fragmentManagerFragmentConnectionsFollowersFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionFragmentConnectionsFollowersFragment = fragmentManagerFragmentConnectionsFollowersFragment.beginTransaction();
                fragmentTransactionFragmentConnectionsFollowersFragment.replace(R.id.fragmentContainerConnections, fragmentFragmentConnectionsFollowersFragment);
                fragmentTransactionFragmentConnectionsFollowersFragment.commit();

                buttonFollowing.setTextColor(Color.GRAY);
                buttonFollowers.setTextColor(Color.BLACK);

            }
        });

        return retView;
    }
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_connection_plus, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);


    }
}

