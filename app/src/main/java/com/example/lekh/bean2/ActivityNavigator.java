package com.example.lekh.bean2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.NavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lekh.bean2.Activitys.ActivityConnectionSearch;
import com.example.lekh.bean2.Activitys.ActivityEventDetail;
import com.example.lekh.bean2.Activitys.ActivityNewBusinesss;
import com.example.lekh.bean2.Activitys.ActivityNewEvent;
import com.example.lekh.bean2.Activitys.ActivityPhotoComment;
import com.example.lekh.bean2.Activitys.ActivityPostSearch;
import com.example.lekh.bean2.Activitys.ConnectionPlus;
import com.example.lekh.bean2.Fragments.ActivityFeedFragment;
import com.example.lekh.bean2.Fragments.BusinessesFragment;
import com.example.lekh.bean2.Fragments.ConnectionsFragment;
import com.example.lekh.bean2.Fragments.EventsFragment;

import com.example.lekh.bean2.Fragments.FragmentGoogleMap;
import com.example.lekh.bean2.Fragments.FragmentProfile;
import com.example.lekh.bean2.Fragments.MessengerFragment;
import com.example.lekh.bean2.Fragments.NotificationsFragment;
import com.example.lekh.bean2.Fragments.PhotosFragment;
import com.example.lekh.bean2.Fragments.SettingsFragment;


public class ActivityNavigator extends AppCompatActivity {

    public DrawerLayout dl;//mDrawer
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Toolbar toolbar2;

    private Button btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

    //    btnProfile = (Button) findViewById(R.id.buttonProfile) ;

        ActivityFeedFragment fragmentActivityNavigator = new ActivityFeedFragment();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        fragmentTransaction1.add(R.id.flContent, fragmentActivityNavigator).commit();

        toolbar2 = (Toolbar) findViewById(R.id.toolbar);  //// Установить Toolbar для замены ActionBar'а.
        setSupportActionBar(toolbar2);


        dl = (DrawerLayout)findViewById(R.id.drawer_layout);  // Найти наш view drawer'а
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);// Найти наш view drawer'а
        setupDrawerContent(nv);
      //  btnProfile = (Button) findViewById(R.id.buttonProfile) ;
        NavigationView navigationView = (NavigationView) findViewById(R.id.nv);
        View  headerView = navigationView.inflateHeaderView(R.layout.nav_header);
        Button accountButton = (Button) headerView.findViewById(R.id.buttonProfile);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.GRAYBeans)));
                FragmentProfile fragmentProfile = new FragmentProfile();
                FragmentManager fragmentManagerFragmentProfile = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentProfile = fragmentManagerFragmentProfile.beginTransaction();
                fragmentTransactionFragmentProfile.replace(R.id.flContent, fragmentProfile);
                fragmentTransactionFragmentProfile.commit();

                dl.closeDrawers();
            }

        });

        Button buttonCloseHeader = (Button) headerView.findViewById(R.id.buttonCloseHeader);
        buttonCloseHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.closeDrawers();
            }

        });
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Создать новый фрагмент и задать фрагмент для отображения
        // на основе нажатия на элемент навигации

        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {



            case R.id.nav_activity_feed_fragment:
               // fragmentClass = ActivityFeedFragment.class;

                ActivityFeedFragment fragmentActivityFeedFragment = new ActivityFeedFragment();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                FragmentManager fragmentManagerActivityFeedFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionActivityFeedFragment = fragmentManagerActivityFeedFragment.beginTransaction();
                fragmentTransactionActivityFeedFragment.replace(R.id.flContent, fragmentActivityFeedFragment);
                fragmentTransactionActivityFeedFragment.commit();

                break;

            case R.id.nav_businesses_fragment:
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                BusinessesFragment fragmentBusinessesFragment = new BusinessesFragment();
                FragmentManager fragmentManagerBusinessesFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesFragment = fragmentManagerBusinessesFragment.beginTransaction();
                fragmentTransactionBusinessesFragment.replace(R.id.flContent, fragmentBusinessesFragment);
                fragmentTransactionBusinessesFragment.commit();

               // fragmentClass = BusinessesFragment.class;

                break;
            case R.id.nav_conections_fragment:
              //  fragmentClass = ConnectionsActivity.class;
               //Intent intent = new Intent(ActivityNavigator.this, ConnectionsActivity.class);
              //  startActivity(intent);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                ConnectionsFragment fragmentConnectionsFragment = new ConnectionsFragment();
                FragmentManager fragmentManagerConnectionsFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionConnectionsFragment = fragmentManagerConnectionsFragment.beginTransaction();
                fragmentTransactionConnectionsFragment.replace(R.id.flContent, fragmentConnectionsFragment);
                fragmentTransactionConnectionsFragment.commit();

                break;
            case R.id.nav_messenger_fragment:
                //fragmentClass = MessengerFragment.class;
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                MessengerFragment fragmentMessengerFragment = new MessengerFragment();
                FragmentManager fragmentManagerMessengerFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionMessengerFragment = fragmentManagerMessengerFragment.beginTransaction();
                fragmentTransactionMessengerFragment.replace(R.id.flContent, fragmentMessengerFragment);
                fragmentTransactionMessengerFragment.commit();
                break;
            case R.id.nav_events_fragment:
               // fragmentClass = EventsFragment.class;
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                EventsFragment fragmentEventsFragment = new EventsFragment();
                FragmentManager fragmentManagerEventsFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionEventsFragment = fragmentManagerEventsFragment.beginTransaction();
                fragmentTransactionEventsFragment.replace(R.id.flContent, fragmentEventsFragment);
                fragmentTransactionEventsFragment.commit();
                break;
            case R.id.nav_photos_fragment:
                //fragmentClass = PhotosFragment.class;
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                PhotosFragment fragmentPhotosFragment = new PhotosFragment();
                FragmentManager fragmentManagerPhotosFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionPhotosFragment = fragmentManagerPhotosFragment.beginTransaction();
                fragmentTransactionPhotosFragment.replace(R.id.flContent, fragmentPhotosFragment);
                fragmentTransactionPhotosFragment.commit();
                break;
            case R.id.nav_notifications_fragment:
               //fragmentClass = NotificationsFragment.class;
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                NotificationsFragment fragmentNotificationsFragment = new NotificationsFragment();
                FragmentManager fragmentManagerNotificationsFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionNotificationsFragment = fragmentManagerNotificationsFragment.beginTransaction();
                fragmentTransactionNotificationsFragment.replace(R.id.flContent, fragmentNotificationsFragment);
                fragmentTransactionNotificationsFragment.commit();
                break;
            case R.id.nav_settings_fragment:
                //fragmentClass = SettingsFragment.class;
              //  ActionBar bar = getActionBar();
                //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#bd1e2d")));
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                SettingsFragment fragmentSettingsFragment = new SettingsFragment();
                FragmentManager fragmentManagerSettingsFragment = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionSettingsFragment = fragmentManagerSettingsFragment.beginTransaction();
                fragmentTransactionSettingsFragment.replace(R.id.flContent, fragmentSettingsFragment);
                fragmentTransactionSettingsFragment.commit();

                break;


            case R.id.nav_logout_fragment:
              // fragmentClass = MainActivity.class;

                Intent intent1 = new Intent(ActivityNavigator.this, MainActivity.class);
                startActivity(intent1);
               break;

            default:
                //fragmentClass = ActivityFeedFragment.class;
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                ActivityFeedFragment fragmentActivityFeedFragment1 = new ActivityFeedFragment();
                FragmentManager fragmentManagerActivityFeedFragment1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionActivityFeedFragment1 = fragmentManagerActivityFeedFragment1.beginTransaction();
                fragmentTransactionActivityFeedFragment1.replace(R.id.flContent, fragmentActivityFeedFragment1);
                fragmentTransactionActivityFeedFragment1.commit();
        }

       // try {
        //   fragment = (Fragment) fragmentClass.newInstance();
      //  } catch (Exception e) {
      //      e.printStackTrace();
        //}

        // Вставить фрагмент, заменяя любой существующий
    //   FragmentManager fragmentManager = getSupportFragmentManager();
//       fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Выделение существующего элемента выполнено с помощью
        // NavigationView
        menuItem.setChecked(true);
        // Установить заголовок для action bar'а
        setTitle(menuItem.getTitle());
        // Закрыть navigation drawer
        dl.closeDrawers();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Действие home/up action bar'а должно открывать или закрывать drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                dl.openDrawer(GravityCompat.START);
                return true;

            case R.id.menuBusinessesP:

                Intent intent2 = new Intent(ActivityNavigator.this, ActivityNewBusinesss.class);
                startActivity(intent2);
                return true;

            case R.id.menuBusinessesM:

                //Intent intent3 = new Intent(ActivityNavigator.this, ActivityGoogleMaps.class);
               // startActivity(intent3);
                FragmentGoogleMap fragmentGoogleMap = new FragmentGoogleMap();
                FragmentManager fragmentManagerFragmentGoogleMap = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionFragmentGoogleMap = fragmentManagerFragmentGoogleMap.beginTransaction();
                fragmentTransactionFragmentGoogleMap.replace(R.id.flContent, fragmentGoogleMap);
                fragmentTransactionFragmentGoogleMap.commit();

                return true;

            case R.id.menuBusinessesMGM:

                //Intent intent3 = new Intent(ActivityNavigator.this, ActivityGoogleMaps.class);
                // startActivity(intent3);
                BusinessesFragment fragmentBusinessesFragment1 = new BusinessesFragment();
                FragmentManager fragmentManagerBusinessesFragment1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransactionBusinessesFragment1 = fragmentManagerBusinessesFragment1.beginTransaction();
                fragmentTransactionBusinessesFragment1.replace(R.id.flContent, fragmentBusinessesFragment1);
                fragmentTransactionBusinessesFragment1.commit();
                return true;

            case R.id.menuBusinessesPMGM:
                Intent intent3 = new Intent(ActivityNavigator.this, ActivityNewBusinesss.class);
                startActivity(intent3);
                return true;

            case R.id.menuConnectionsPlus:

                 Intent intent4 = new Intent(ActivityNavigator.this, ConnectionPlus.class);
                 startActivity(intent4);
                return true;

            case R.id.menuCommentPlus:
                Intent intent5 = new Intent(ActivityNavigator.this, ActivityPhotoComment.class);
              /*  Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
                //Тип получаемых объектов - image:
                photoPickerIntent.setType("image/*");
                startActivity(photoPickerIntent);*/
                startActivity(intent5);
     return true;

            case R.id.menEventP:
                Intent intent6 = new Intent(ActivityNavigator.this, ActivityNewEvent.class);
                startActivity(intent6);
                return true;

            case R.id.menuLoop:
                Intent intent7 = new Intent(ActivityNavigator.this, ActivityPostSearch.class);
                startActivity(intent7);
                return true;
            case R.id.menuConnectionsLoop:
                Intent intent8 = new Intent(ActivityNavigator.this, ActivityConnectionSearch.class);
                startActivity(intent8);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
