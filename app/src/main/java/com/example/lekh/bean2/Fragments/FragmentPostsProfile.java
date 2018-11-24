package com.example.lekh.bean2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lekh.bean2.Adapters.AdapterProfilePostsAndSlider;
import com.example.lekh.bean2.Models.Data;
import com.example.lekh.bean2.Models.DataProfilePostMe;
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.Activitys.ActivityAboutUs;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Adapters.AdapterProfilePostsMe;
import com.example.lekh.bean2.Adapters.Adapter_Businesses;
import com.example.lekh.bean2.Models.ModelProfilePostsMe;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentPostsProfile extends Fragment implements AdapterProfilePostsAndSlider.OnUserMenuClickListener {

    RecyclerView mRecyclerViewP;

    AdapterProfilePostsAndSlider adapter;

    ArrayList<DataProfilePostMe> list;

    private ImageView newimgIcon;
    private ImageView newimgPost;
    private TextView namePost;
    private TextView dataPost;
    private TextView postPost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View retView = inflater.inflate(R.layout.fragment_fragment_posts_profile, container, false);

        mRecyclerViewP = (RecyclerView) retView.findViewById(R.id.rvFragmentPostsMeProfile);
        list = new ArrayList<>();
        list.add(new DataProfilePostMe(R.drawable.one,
                R.drawable.icon_bean_not_like, R.drawable.one,
                R.drawable.two, R.drawable.free, R.drawable.icon_coment,
                "Peter Clarckson", "September 1 ", "business details Rating delete",
                "alexandrov", "and ", "34",
                "others", "33"));
        list.add(new DataProfilePostMe( R.drawable.one,
                R.drawable.icon_bean_like, R.drawable.one,
                R.drawable.two, R.drawable.free, R.drawable.icon_coment,
                "Peter Clarckson", "September 1 ", "business details Rating delete",
                "alexandrov", "and ", "64",
                "others", "38"));


        adapter = new AdapterProfilePostsAndSlider(list, getActivity(), new AdapterProfilePostsAndSlider.OnUserMenuClickListener() {
            @Override
            public void onUserMenuClick(View v, int userPosition) {
                showPopupMenu(v, userPosition);

            }
        });

      //  adapter = new AdapterProfilePostsAndSlider(list, getActivity());
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewP.setLayoutManager(linearLayoutManager);
        mRecyclerViewP.setItemAnimator(new DefaultItemAnimator());


        mRecyclerViewP.setAdapter(adapter);

        adapter.SetOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {

                switch (v.getId()) {
                    case R.id.textViewPostPostMe:
                        Intent intent = new Intent(getContext(), ActivityEventDetail.class);
                        startActivity(intent);
                        break;

                    case R.id.imageViewIconPostMe:
                        Intent intent2 = new Intent(getContext(), ActivityEventDetail.class);
                        startActivity(intent2);
                        break;
                }
            }
        });


        return retView;
    }

    private void showPopupMenu (View v,final int userPosition) {
        PopupMenu popupMenu = new PopupMenu(getContext(), v);
        popupMenu.inflate(R.menu.menu_circle);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.circleDelete:
                        Toast.makeText(getContext(), "press Delete", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.circleEdit:
                        Intent intent3 = new Intent(getContext(), ActivityEventDetail.class);
                        startActivity(intent3);
                        break;
                    default:
                        break;
                }
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        popupMenu.show();
    }



    @Override
    public void onUserMenuClick(View view, int userPosition) {
        showPopupMenu(view, userPosition);
    }


}
