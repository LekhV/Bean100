package com.example.lekh.bean2.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lekh.bean2.Activitys.ActivityAboutUs;
import com.example.lekh.bean2.Activitys.ActivityComments;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Activitys.ActivityPostsDetails;
import com.example.lekh.bean2.Activitys.ActivityProfileFriends;
import com.example.lekh.bean2.Adapters.AdapterActivityFeed;
import com.example.lekh.bean2.Adapters.AdapterActivityFeedIconSmall;
import com.example.lekh.bean2.Adapters.AdapterActivityFeedIconsPlus;
import com.example.lekh.bean2.Adapters.AdapterActivityFeedsIconNew;
import com.example.lekh.bean2.Adapters.SliderAdapterPostDetails;
import com.example.lekh.bean2.Models.DataIcons;
import com.example.lekh.bean2.Models.DataProfilePostMe;
import com.example.lekh.bean2.Models.ModelActivityFeedIcons;
import com.example.lekh.bean2.Models.ModelIconsActivityFeed;
import com.example.lekh.bean2.Models.ModelSlider;
import com.example.lekh.bean2.OnItemClickListener;
import com.example.lekh.bean2.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityFeedFragment extends Fragment {

    FragmentActivity mActivity;
    private RecyclerView myRecycler;
    private List<ModelIconsActivityFeed> modelIconsActivityFeeds;
    private AdapterActivityFeedIconSmall adapterActivityFeedIcons;

    private RecyclerView myRecyclerIcons;
    private ArrayList<ModelActivityFeedIcons> modelActivityFeedIconsList;
    private AdapterActivityFeedIconsPlus adapterActivityFeedIconsPlus;

    private RecyclerView myRecyclerIconsV;
    private ArrayList<ModelActivityFeedIcons> modelActivityFeedIconsListV;
    private AdapterActivityFeedIconsPlus adapterActivityFeedIconsPlusV;

    private ImageView fimgIconAF;
    private ImageView fimageViewPostAF;
    private ImageView fimgLikeAF;
    private ImageView fimgIconAF1;
    private ImageView fimgIconAF2;
    private ImageView fimgIconAF3;
    private ImageView fimgCommentAF;

    private TextView fnameAFOne;
    private TextView fdataAF;
    private TextView fpostAF;
    private TextView fnameAF2;
    private TextView fandAF;
    private TextView fnumberAF;
    private TextView fothersAF;
    private TextView fnumberTextAF;

    RecyclerView mRecyclerViewAF;
    AdapterActivityFeed adapterActivityFeed;

    ArrayList<DataProfilePostMe> dataActivityFeed;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = (FragmentActivity) activity;
        setRetainInstance(true);
    }
    public static ActivityFeedFragment newInstance() {

        Bundle args = new Bundle();

        ActivityFeedFragment fragment = new ActivityFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_activity_feed, container, false);

        getActivity().setTitle("ActivityFeed");
       // Toolbar toolbar = (Toolbar) retView.findViewById(R.id.toolbar);

        // one
   //     myRecycler = retView.findViewById(R.id.rvActivityFeed3);

  //      LinearLayoutManager layoutManager1
   //             = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false); // что б сделать горизонтальный скролл

    //    myRecycler.setLayoutManager(layoutManager1);

  /*      modelIconsActivityFeeds = new ArrayList<>();

        modelIconsActivityFeeds.add(new ModelIconsActivityFeed(R.drawable.one));
        modelIconsActivityFeeds.add(new ModelIconsActivityFeed(R.drawable.two));
        modelIconsActivityFeeds.add(new ModelIconsActivityFeed(R.drawable.free));
        modelIconsActivityFeeds.add(new ModelIconsActivityFeed(R.drawable.free));
        modelIconsActivityFeeds.add(new ModelIconsActivityFeed(R.drawable.one));
        modelIconsActivityFeeds.add(new ModelIconsActivityFeed(R.drawable.two));

        adapterActivityFeedIcons= new AdapterActivityFeedIconSmall(getContext(), modelIconsActivityFeeds) { };

        myRecycler.setAdapter(adapterActivityFeedIcons);
*/
     /*   myRecyclerIcons = retView.findViewById(R.id.rvActivityFeed3);
        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerIcons.setLayoutManager(layoutManager1);
        modelActivityFeedIconsList = new ArrayList<>();
        modelActivityFeedIconsList.add(new ModelActivityFeedIcons(R.drawable.free));
        adapterActivityFeedIconsPlus = new AdapterActivityFeedIconsPlus(modelActivityFeedIconsList , getContext()) { };

        myRecyclerIcons.setAdapter(adapterActivityFeedIconsPlus);*/
        myRecyclerIconsV = retView.findViewById(R.id.rvActivityFeed3);    // two
        ArrayList<DataIcons> list = new ArrayList<>();
        list.add(new DataIcons(DataIcons.IMAGEMY_TYPE, R.drawable.one));

        list.add(new DataIcons(DataIcons.IMAGENOT_TYPE, R.drawable.two));
        list.add(new DataIcons(DataIcons.IMAGENOT_TYPE, R.drawable.free));
        list.add(new DataIcons(DataIcons.IMAGENOT_TYPE, R.drawable.two));
        list.add(new DataIcons(DataIcons.IMAGENOT_TYPE, R.drawable.free));
        list.add(new DataIcons(DataIcons.IMAGENOT_TYPE, R.drawable.two));
        list.add(new DataIcons(DataIcons.IMAGENOT_TYPE, R.drawable.free));

        AdapterActivityFeedsIconNew adapter = new AdapterActivityFeedsIconNew(list, getContext());

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        myRecyclerIconsV.setLayoutManager(layoutManager1);
        myRecyclerIconsV.setAdapter(adapter);

        adapter.SetOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {

                switch (v.getId()) {
                    case R.id.imageButtonAF:
                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

                        photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                        photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                        photoPickerIntent.setType("image/*");

                        startActivity(photoPickerIntent);
                       // Intent intentP = new Intent(getContext(), ActivityProfileFriends.class);
                       // startActivity(intentP);
                        break;

                }
            }
        });
        // viewPager=(ViewPager)retView.findViewById(R.id.viewPagerAF);
     //   indicator=(TabLayout)retView.findViewById(R.id.indicatorAF);

        mRecyclerViewAF = (RecyclerView) retView.findViewById(R.id.rvActivityFeed);

        dataActivityFeed = new ArrayList<>();

        dataActivityFeed.add(new DataProfilePostMe(R.drawable.one,
                R.drawable.icon_bean_not_like, R.drawable.one,
                R.drawable.two, R.drawable.free, R.drawable.icon_coment,
                "Peter Clarckson", "September 1 ", "business details Rating delete",
                "alexandrov", "and ", "34",
                "others", "33"));
        dataActivityFeed.add(new DataProfilePostMe(R.drawable.one,
                R.drawable.icon_bean_like, R.drawable.one,
                R.drawable.two, R.drawable.free, R.drawable.icon_coment,
                "Peter Clarckson", "September 1 ", "business details Rating delete",
                "alexandrov", "and ", "34",
                "others", "33"));

        adapterActivityFeed = new AdapterActivityFeed(dataActivityFeed, getActivity(), new AdapterActivityFeed.OnUserMenuClickListener() {
            @Override
            public void onUserMenuClick(View v, int userPosition) {
                showPopupMenu(v, userPosition);

            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewAF.setLayoutManager(linearLayoutManager);
        mRecyclerViewAF.setItemAnimator(new DefaultItemAnimator());

        mRecyclerViewAF.setAdapter(adapterActivityFeed);

        adapterActivityFeed.SetOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {
                switch (v.getId()) {
                    case R.id.imageViewIconAF:
                        Intent intent2 = new Intent(getContext(), ActivityProfileFriends.class);
                        startActivity(intent2);
                        break;
                    case R.id.textViewNameAFOne:
                        Intent intent3 = new Intent(getContext(), ActivityPostsDetails.class);
                        startActivity(intent3);
                        break;
                    case R.id.textViewDataAF:
                        Intent intent4 = new Intent(getContext(), ActivityPostsDetails.class);
                        startActivity(intent4);
                        break;
                    case R.id.textViewPostAF:
                        Intent intent5 = new Intent(getContext(), ActivityPostsDetails.class);
                        startActivity(intent5);
                        break;
                    case R.id.imageViewCommentAF:
                        Intent intent6 = new Intent(getContext(), ActivityComments.class);
                        startActivity(intent6);
                        break;

                }
            }
        });
        return retView;
    }
    private void showPopupMenu(View v, final int userPosition) {
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
                        Toast.makeText(getContext(), "press Edit", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                adapterActivityFeed.notifyDataSetChanged();
                return true;
            }
        });
        popupMenu.show();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_a_f, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
