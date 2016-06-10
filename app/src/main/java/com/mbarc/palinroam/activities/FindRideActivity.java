package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.HomeViewPageAdapter;
import com.mbarc.palinroam.fragments.FindRideFragment;
import com.mbarc.palinroam.fragments.OfferRideFragment;


import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class FindRideActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @BindString(R.string.findride_text)
    String findRide;
    @BindString(R.string.offerride_text)
    String offerRide;
    HomeViewPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_ride);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.find_ride_menu);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.navication));
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        pageAdapter = new HomeViewPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new FindRideFragment(), findRide);
        pageAdapter.addFragment(new OfferRideFragment(), offerRide);
        viewPager.setAdapter(pageAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.find_ride_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_user_profile) {
            startActivity(new Intent(FindRideActivity.this,UserProfileActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
