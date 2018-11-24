package com.example.lekh.bean2.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lekh.bean2.Activitys.ActivityAddPost;
import com.example.lekh.bean2.Activitys.ActivityBusinessDetaila;
import com.example.lekh.bean2.Activitys.ActivityEditProfileInformation;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Activitys.ActivityPostsDetails;
import com.example.lekh.bean2.R;


public class FragmentProfile extends Fragment{

    public TextView textXXPhoto;
    public TextView textPhoto;
    public TextView textXXConnections;
    public TextView textConnections;
    public TextView textXXEvents;
    public TextView textEvents;
    public TextView textXXBeansProfile;
    public TextView textBeansProfile;

    Button buttonPostsProfileMe;
    Button buttonBeansProfileMe;
    Button buttonplusProfile;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment_profile, container, false);
        View retView = inflater.inflate(R.layout.fragment_fragment_profile, container, false);

        getActivity().setTitle("Profile");
        Toolbar toolbar = (Toolbar) retView.findViewById(R.id.toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentPostsProfile fragmentFragmentPostsProfile = new FragmentPostsProfile();
        FragmentManager fragmentManagerFragmentPostsProfile = getFragmentManager();
        FragmentTransaction fragmentTransactionFragmentPostsProfile= fragmentManagerFragmentPostsProfile.beginTransaction();
        fragmentTransactionFragmentPostsProfile.add(R.id.fragmentContainerProfileMe, fragmentFragmentPostsProfile).commit();


        buttonPostsProfileMe = (Button) retView.findViewById(R.id.buttonPostsPr);
        buttonPostsProfileMe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentPostsProfile fragmentFragmentPostsProfile2 = new FragmentPostsProfile();
                FragmentManager fragmentManagerFragmentPostsProfile2 = getFragmentManager();
                FragmentTransaction fragmentTransactionFragmentPostsProfile2= fragmentManagerFragmentPostsProfile2.beginTransaction();
                fragmentTransactionFragmentPostsProfile2.replace(R.id.fragmentContainerProfileMe, fragmentFragmentPostsProfile2);
                fragmentTransactionFragmentPostsProfile2.commit();
                buttonPostsProfileMe.setTextColor(Color.BLACK);
                buttonBeansProfileMe.setTextColor(Color.GRAY);
            }
        });

        buttonBeansProfileMe = (Button) retView.findViewById(R.id.buttonBeansPr);
        buttonBeansProfileMe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentBeansMe fragmentFragmentFragmentBeansMe = new FragmentBeansMe();
                FragmentManager fragmentManagerFragmentFragmentBeansMe = getFragmentManager();
                FragmentTransaction fragmentTransactionFragmentBeansMe = fragmentManagerFragmentFragmentBeansMe.beginTransaction();
                fragmentTransactionFragmentBeansMe.replace(R.id.fragmentContainerProfileMe, fragmentFragmentFragmentBeansMe);
                fragmentTransactionFragmentBeansMe.commit();

                buttonPostsProfileMe.setTextColor(Color.GRAY);
                buttonBeansProfileMe.setTextColor(Color.BLACK);

            }
        });

        buttonplusProfile = retView.findViewById(R.id.buttonplusProfile);
        buttonplusProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showPopupMenuF (view);
              // Intent intent = new Intent(getContext(), ActivityEditProfileInformation.class);
                //startActivity(intent);

            }
        });

        textXXPhoto = retView.findViewById(R.id.textViewXXPhotoProfile);
        textXXPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                PhotosFragment fragmentPhotosFragment = new PhotosFragment();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerPhotosFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionPhotosFragment = fragmentManagerPhotosFragment.beginTransaction();
                fragmentTransactionPhotosFragment.replace(R.id.flContent, fragmentPhotosFragment);
                fragmentTransactionPhotosFragment.commit();
                //textXXPhoto.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            }
        });
        textPhoto = retView.findViewById(R.id.textViewPhotoProfile);
        textPhoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                PhotosFragment fragmentPhotosFragment2 = new PhotosFragment();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerPhotosFragment2 = getFragmentManager();
                FragmentTransaction fragmentTransactionPhotosFragment2 = fragmentManagerPhotosFragment2.beginTransaction();
                fragmentTransactionPhotosFragment2.replace(R.id.flContent, fragmentPhotosFragment2);
                fragmentTransactionPhotosFragment2.commit();

            }
        });
        textXXConnections = retView.findViewById(R.id.textViewXXConnectionsProfile);
        textXXConnections.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ConnectionsFragment fragmentConnectionsFragment = new ConnectionsFragment();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerConnectionsFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment = fragmentManagerConnectionsFragment.beginTransaction();
                fragmentTransactionConnectionsFragment.replace(R.id.flContent, fragmentConnectionsFragment);
                fragmentTransactionConnectionsFragment.commit();

            }
        });
        textConnections = retView.findViewById(R.id.textViewConnectionsProfile);
        textConnections.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                ConnectionsFragment fragmentConnectionsFragment2 = new ConnectionsFragment();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerConnectionsFragment2 = getFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment2 = fragmentManagerConnectionsFragment2.beginTransaction();
                fragmentTransactionConnectionsFragment2.replace(R.id.flContent, fragmentConnectionsFragment2);
                fragmentTransactionConnectionsFragment2.commit();

            }
        });
        textXXEvents = retView.findViewById(R.id.textViewXXEventsProfile);
        textXXEvents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EventsFragment fragmentEventsFragment = new EventsFragment();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerEventsFragment = getFragmentManager();
                FragmentTransaction fragmentTransactionEventsFragment = fragmentManagerEventsFragment.beginTransaction();
                fragmentTransactionEventsFragment.replace(R.id.flContent, fragmentEventsFragment);
                fragmentTransactionEventsFragment.commit();

            }
        });
        textEvents = retView.findViewById(R.id.textViewEventsProfile);
        textEvents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EventsFragment fragmentEventsFragment2 = new EventsFragment();
                ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerEventsFragment2 = getFragmentManager();
                FragmentTransaction fragmentTransactionEventsFragment2 = fragmentManagerEventsFragment2.beginTransaction();
                fragmentTransactionEventsFragment2.replace(R.id.flContent, fragmentEventsFragment2);
                fragmentTransactionEventsFragment2.commit();


            }
        });
        textXXBeansProfile = retView.findViewById(R.id.textViewXXBeansProfile);
        textXXBeansProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentBeansMe fragmentFragmentFragmentBeansMe1 = new FragmentBeansMe();
                FragmentManager fragmentManagerFragmentFragmentBeansMe1 = getFragmentManager();
                FragmentTransaction fragmentTransactionFragmentBeansMe1 = fragmentManagerFragmentFragmentBeansMe1.beginTransaction();
                fragmentTransactionFragmentBeansMe1.replace(R.id.fragmentContainerProfileMe, fragmentFragmentFragmentBeansMe1);
                fragmentTransactionFragmentBeansMe1.commit();

                buttonPostsProfileMe.setTextColor(Color.GRAY);
                buttonBeansProfileMe.setTextColor(Color.BLACK);

            }
        });
        textBeansProfile = retView.findViewById(R.id.textViewBeansProfile);
        textBeansProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                FragmentBeansMe fragmentFragmentFragmentBeansMe2 = new FragmentBeansMe();
                FragmentManager fragmentManagerFragmentFragmentBeansMe2 = getFragmentManager();
                FragmentTransaction fragmentTransactionFragmentBeansMe2 = fragmentManagerFragmentFragmentBeansMe2.beginTransaction();
                fragmentTransactionFragmentBeansMe2.replace(R.id.fragmentContainerProfileMe, fragmentFragmentFragmentBeansMe2);
                fragmentTransactionFragmentBeansMe2.commit();

                buttonPostsProfileMe.setTextColor(Color.GRAY);
                buttonBeansProfileMe.setTextColor(Color.BLACK);

            }
        });

     return retView;

    }

    private void showPopupMenuF(View view) {
            PopupMenu popupMenu = new PopupMenu(getContext(), view);
            popupMenu.inflate(R.menu.menu_profile_me_plus);

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.profilePost:
                            Intent intent4 = new Intent(getContext(),  ActivityAddPost.class);
                            startActivity(intent4);
                            break;
                        case R.id.profileStory:
                            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

                            photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                            photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                            photoPickerIntent.setType("image/*");

                            startActivity(photoPickerIntent);
                            Intent intent3 = new Intent(getContext(),  ActivityPostsDetails.class);
                            startActivity(intent3);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            });
            popupMenu.show();
        }


    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);



    }

}