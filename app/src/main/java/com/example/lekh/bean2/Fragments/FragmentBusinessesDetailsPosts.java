package com.example.lekh.bean2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lekh.bean2.Activitys.ActivityAddPost;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Adapters.AdapterBusinessDetailsPosts;
import com.example.lekh.bean2.Adapters.AdapterBusinessPostsD;
import com.example.lekh.bean2.Models.DataProfilePostMe;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;

public class FragmentBusinessesDetailsPosts extends Fragment  implements View.OnClickListener{ //implements AdapterBusinessPostsD.OnUserMenuClickListener {


    Button BtnAddPostBusiness;
    Button BtnAddStoryBusiness;

   /* RecyclerView mRecyclerViewBDP;
    AdapterBusinessPostsD adapterBDP;
    ArrayList<DataProfilePostMe> listBDP;
*/
    public FragmentBusinessesDetailsPosts() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fragment_businesses_details_posts, container, false);

        View retView = inflater.inflate(R.layout.fragment_fragment_businesses_details_posts, container, false);
        BtnAddPostBusiness = retView.findViewById(R.id.buttonBusinessNewPost);
        BtnAddStoryBusiness = retView.findViewById(R.id.buttonBusinessAddStory);


/*
        mRecyclerViewBDP = (RecyclerView) retView.findViewById(R.id.rvBusinessDetailsPosts);
        listBDP = new ArrayList<>();
        listBDP.add(new DataProfilePostMe(R.drawable.one,
                R.drawable.icon_bean_not_like, R.drawable.one,
                R.drawable.two, R.drawable.free, R.drawable.icon_coment,
                "Peter Clarckson", "September 1 ", "business details Rating delete",
                "alexandrov", "and ", "34",
                "others", "33"));
        listBDP.add(new DataProfilePostMe( R.drawable.one,
                R.drawable.icon_bean_like, R.drawable.one,
                R.drawable.two, R.drawable.free, R.drawable.icon_coment,
                "Peter Clarckson", "September 1 ", "business details Rating delete",
                "alexandrov", "and ", "64",
                "others", "38"));


        adapterBDP = new AdapterBusinessPostsD(listBDP, getActivity(), new AdapterBusinessPostsD.OnUserMenuClickListener() {
            @Override
            public void onUserMenuClick(View v, int userPosition) {
                showPopupMenu(v, userPosition);

            }
        });

        //  adapter = new AdapterProfilePostsAndSlider(list, getActivity());
        final LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewBDP.setLayoutManager(linearLayoutManager2);
        mRecyclerViewBDP.setItemAnimator(new DefaultItemAnimator());


        mRecyclerViewBDP.setAdapter(adapterBDP);

        adapterBDP.SetOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {

                switch (v.getId()) {
                    case R.id.imageViewIconDetailPostBusiness:
                        Intent intent = new Intent(getContext(), ActivityEventDetail.class);
                        startActivity(intent);
                        break;

                    case R.id.textViewPostDetailPostBusiness:
                        Intent intent2 = new Intent(getContext(), ActivityEventDetail.class);
                        startActivity(intent2);
                        break;
                }
            }
        });

*/
        return retView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBusinessNewPost:
                Intent intent = new Intent(getContext(),  ActivityAddPost.class);
                startActivity(intent);
                break;

            case R.id.buttonBusinessAddStory:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                photoPickerIntent.setType("image/*");
                startActivity(photoPickerIntent);
                break;
        }
    }
/*
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
                adapterBDP.notifyDataSetChanged();
                return true;
            }
        });
        popupMenu.show();
    }



    @Override
    public void onUserMenuClick(View view, int userPosition) {
        showPopupMenu(view, userPosition);
    }


      //  return retView;*/
    }

