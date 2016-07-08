package com.mbarc.palinroam.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.HomeViewPageAdapter;
import com.mbarc.palinroam.fragments.LoginFragment;
import com.mbarc.palinroam.fragments.NoFriendsFragment;
import com.mbarc.palinroam.fragments.RequestedFriendsFragment;
import com.mbarc.palinroam.fragments.SignupFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FriendsDetailedActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager friendsViewPager;
    HomeViewPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_detailed);
        ButterKnife.bind(this);
        toolbar.setTitle(" Friends ");
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.backarrowicon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        setupViewPager(friendsViewPager);
        tabLayout.setupWithViewPager(friendsViewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        pageAdapter = new HomeViewPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new NoFriendsFragment(),"Friends");
        pageAdapter.addFragment(new RequestedFriendsFragment(),"Requests");
        pageAdapter.addFragment(new RequestedFriendsFragment(),"Suggestions");
        viewPager.setAdapter(pageAdapter);
    }

}
