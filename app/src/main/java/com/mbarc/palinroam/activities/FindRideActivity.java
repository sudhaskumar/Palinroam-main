package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.FindRideListAdapter;
import com.mbarc.palinroam.adapter.HomeViewPageAdapter;
import com.mbarc.palinroam.data.FindRideListData;
import com.mbarc.palinroam.fragments.FindRideFragment;
import com.mbarc.palinroam.fragments.OfferRideFragment;
import com.mbarc.palinroam.util.SessionManager;
import com.mbarc.palinroam.views.RecyclerItemClickListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;


import java.util.ArrayList;
import java.util.List;

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
    @BindString(R.string.high_certainty)
    String highCertainty;
    @BindString(R.string.low_certainty)
    String lowCertainty;
    @BindString(R.string.medium_certainty)
    String mediumCertainty;
    @Bind(R.id.sliding_layout)
    SlidingUpPanelLayout slidingUpPanelLayout;
    @Bind(R.id.top_ride_list)RecyclerView topRideList;
    String TAG = "SlideView";
    HomeViewPageAdapter pageAdapter;
    SessionManager manager;
    FindRideListAdapter findRideListAdapter;


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
        manager = new SessionManager();
        tabLayout.setupWithViewPager(viewPager);
        slidingUpPanelLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }
            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                Log.i(TAG, "onPanelStateChanged " + newState);
            }
        });
        slidingUpPanelLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });
        topRideList.setLayoutManager(new LinearLayoutManager(this));
        findRideListAdapter = new FindRideListAdapter(FindRideActivity.this, fill_with_dummy_data());
        topRideList.setAdapter(findRideListAdapter);
        findRideListAdapter.notifyDataSetChanged();
        topRideList.addOnItemTouchListener(
                new RecyclerItemClickListener(FindRideActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        startActivity(new Intent(FindRideActivity.this, RideTaggedDetailView.class));
                    }
                })
        );

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
            startActivity(new Intent(FindRideActivity.this, UserProfileActivity.class));
            return true;
        } else if (id == R.id.menu_logout) {
            manager.setPreferences(FindRideActivity.this, "status", "0");
            finish();
            return true;
        } else if (id == R.id.menu_friends_profile) {
            startActivity(new Intent(FindRideActivity.this, FriendsDetailedActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (slidingUpPanelLayout != null &&
                (slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {

            super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
    }

    public List<FindRideListData> fill_with_dummy_data() {

        List<FindRideListData> findRideListData = new ArrayList<>();
        findRideListData.add(new FindRideListData("Sudhaskumar", "24 Age", "216 Friends", "34 Mutual", "500", "Fri 16 Jul", "05:45 pm", "4.9", "3 Seat", highCertainty));
        findRideListData.add(new FindRideListData("Nagasundari", "45 Age", "21 Friends", "12 Mutual", "300", "Tus 3 May", "06:45 pm", "4.4", "2 Seat", lowCertainty));
        findRideListData.add(new FindRideListData("Prasanna", "32 Age", "142 Friends", "67 Mutual", "700", "Mon 7 Feb", "09:45 pm", "4.0", "3 Seat", highCertainty));
        findRideListData.add(new FindRideListData("Thiyagu", "26 Age", "236 Friends", "4 Mutual", "600", "Fri 6 Jul", "05:45 pm", "3.9", "1 Seat", mediumCertainty));
        findRideListData.add(new FindRideListData("Visu", "22 Age", "265 Friends", "24 Mutual", "500", "Fri 3 Aug", "07:45 am", "4.5", "3 Seat", highCertainty));
        findRideListData.add(new FindRideListData("Suganya", "24 Age", "216 Friends", "34 Mutual", "500", "Fri 16 Jul", "05:45 pm", "4.9", "3 Seat", mediumCertainty));
        findRideListData.add(new FindRideListData("Renu", "24 Age", "216 Friends", "34 Mutual", "500", "Fri 16 Jul", "05:45 pm", "4.9", "3 Seat", mediumCertainty));
        findRideListData.add(new FindRideListData("Kumar", "24 Age", "216 Friends", "34 Mutual", "500", "Fri 16 Jul", "05:45 pm", "4.9", "3 Seat", lowCertainty));
        findRideListData.add(new FindRideListData("Rajan", "24 Age", "216 Friends", "34 Mutual", "500", "Fri 16 Jul", "05:45 pm", "4.9", "3 Seat", highCertainty));
        return findRideListData;
    }

}
