package com.example.lekh.bean2.Fragments;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lekh.bean2.Activitys.ActivityAboutUs;
import com.example.lekh.bean2.Activitys.ActivityEditProfileInformation;
import com.example.lekh.bean2.Activitys.ActivityHelp;
import com.example.lekh.bean2.Activitys.ActivityNotificationSettings;
import com.example.lekh.bean2.R;


public class SettingsFragment extends Fragment {


    public SettingsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.fragment_settings, container, false);
        View retView = inflater.inflate(R.layout.fragment_settings, container, false);


        Button buttonEditProfileInformation = retView.findViewById(R.id.buttonEditProfileInformation);
        buttonEditProfileInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityEditProfileInformation.class);
                startActivity(intent); }
        });

        Button buttonNotificationSettings = retView.findViewById(R.id.buttonNotificationSettings);
        buttonNotificationSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityNotificationSettings.class);
                startActivity(intent); }
        });

        Button buttonAboutUs = retView.findViewById(R.id.buttonAboutUs);
        buttonAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityAboutUs.class);
                startActivity(intent); }
        });

        Button buttonHelp = retView.findViewById(R.id.buttonHelp);
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityHelp.class);
                startActivity(intent); }
        });

        return retView;
    }

}
