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
import android.widget.ImageView;

import com.example.lekh.bean2.Activitys.ActivityAboutUs;
import com.example.lekh.bean2.Activitys.ActivityBusinessDetaila;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Activitys.ActivityRequests;
import com.example.lekh.bean2.Adapters.AdapterRequests;
import com.example.lekh.bean2.Adapters.Adapter_Businesses;
import com.example.lekh.bean2.Models.ModelBusiness;
import com.example.lekh.bean2.Models.ModelRequests;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class BusinessesFragment  extends Fragment {

    private ImageView bBobF;
    FragmentActivity mActivity;

   private RecyclerView mRecyclerView;
   private Adapter_Businesses adapter_businesses;
    private List<ModelBusiness> modelBusinesses;

    public BusinessesFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentActivity) activity;
        setRetainInstance(true);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_businesses, container, false);
        View retView = inflater.inflate(R.layout.fragment_businesses, container, false);

        bBobF = (ImageView) retView.findViewById(R.id.imageViewBobs);
        mRecyclerView = (RecyclerView) retView.findViewById(R.id.rvBusiness);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        modelBusinesses = new ArrayList<>();
        modelBusinesses.add(new ModelBusiness("Business Name", "Location","Working Hours",
                R.drawable.brand_post,R.drawable.bob_f));
        modelBusinesses.add(new ModelBusiness("Business Name", "Location","Working Hours",
                R.drawable.brand_post,R.drawable.bob_f));
        modelBusinesses.add(new ModelBusiness("Business Name", "Location","Working Hours",
                R.drawable.brand_post,R.drawable.bob_f ));

        adapter_businesses = new Adapter_Businesses(getContext(), modelBusinesses);

        adapter_businesses.SetClickListener(new Adapter_Businesses.ItemClickListenerAB() {

            @Override
            public void onItemClick(View v , int position) {

                switch (v.getId()) {
                    case R.id.textBusinessName:
                        Intent intent = new Intent(getContext(), ActivityBusinessDetaila.class);
                        startActivity(intent);
                        break;
                    case R.id.textLocation:
                        Intent intent2 = new Intent(getContext(), ActivityBusinessDetaila.class);
                        startActivity(intent2);
                        break;

                    case R.id.textWorkingHouse:
                        Intent intent3 = new Intent(getContext(), ActivityBusinessDetaila.class);
                        startActivity(intent3);
                        break;
                    case R.id.imageViewBrandSmoll:
                        Intent intent4 = new Intent(getContext(), ActivityBusinessDetaila.class);
                        startActivity(intent4);
                        break;
                    case R.id.imageViewBobs:
                        Intent intent6 = new Intent(getContext(), ActivityBusinessDetaila.class);
                        startActivity(intent6);
                        break;
                        //bBobF.setVisibility(View.INVISIBLE);

                }
            }
        });
        mRecyclerView.setAdapter(adapter_businesses);

        return retView;
}
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_businesses, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
    //setTitle(item.getTitle());
    }
}
