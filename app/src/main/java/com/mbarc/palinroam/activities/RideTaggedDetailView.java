package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.FindRideListAdapter;
import com.mbarc.palinroam.adapter.StopOverListAdapter;
import com.mbarc.palinroam.adapter.TaggedFriendListAdapter;
import com.mbarc.palinroam.data.FindRideListData;
import com.mbarc.palinroam.data.StopOverData;
import com.mbarc.palinroam.data.TaggedFriendsData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RideTaggedDetailView extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.stop_over_list)
    RecyclerView stopOverList;
    @Bind(R.id.co_passenger_list)RecyclerView coPassengerList;
    @Bind(R.id.tagged_friend_list)RecyclerView taggedFriendList;
    @Bind(R.id.provider_profile_layout)
    LinearLayout providerProfileDetails;
    @OnClick(R.id.provider_profile_layout)
    public void fullProfileViewAction(View view) {
        startActivity(new Intent(RideTaggedDetailView.this, PassengerProfileViewActivity.class));
    }

    @Bind(R.id.list_of_stop_over_layout)
    LinearLayout listOfStopOverLayout;
    @Bind(R.id.stop_over_layout)
    LinearLayout stopOverLayout;

    @OnClick(R.id.stop_over_layout)
    public void stopOverListVisblityAction(View view) {
        if(listOfStopOverLayout.getVisibility()==View.GONE)
        {
            listOfStopOverLayout.setVisibility(View.VISIBLE);
        }else{
            listOfStopOverLayout.setVisibility(View.GONE);
        }
    }

    StopOverListAdapter stopOverListAdapter;
    TaggedFriendListAdapter taggedFriendListAdapter;
    @BindString(R.string.demo_city1)
    String demoCity1;
    @BindString(R.string.demo_city2)
    String demoCity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_tagged_detail_view);
        ButterKnife.bind(this);
        toolbar.setTitle(demoCity1 + " >> " + demoCity2);
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.backarrowicon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        stopOverList.setLayoutManager(new LinearLayoutManager(this));
        stopOverListAdapter = new StopOverListAdapter(RideTaggedDetailView.this, fill_with_dummy_data());
        stopOverList.setAdapter(stopOverListAdapter);
        stopOverListAdapter.notifyDataSetChanged();
        setRecycleList(coPassengerList,false);
        setRecycleList(taggedFriendList,true);

    }

    public List<StopOverData> fill_with_dummy_data() {

        List<StopOverData> stopOverData = new ArrayList<>();
        stopOverData.add(new StopOverData("Chennai", "Thirchy", "120", "180 Rs"));
        stopOverData.add(new StopOverData("Thirchy", "Madurai", "208", "220 Rs"));
        stopOverData.add(new StopOverData("Madurai", "Virudhunagar", "80", "40 Rs"));
        stopOverData.add(new StopOverData("Virudhunagar", "Kovilpatti", "60", "20 Rs"));
        return stopOverData;
    }
    public List<TaggedFriendsData> tagged_friend_dummy_data() {

        List<TaggedFriendsData> taggedFriendsDatas = new ArrayList<>();
        taggedFriendsDatas.add(new TaggedFriendsData( "213 Friends","sudhaskumar", "24 Age", ""));
        taggedFriendsDatas.add(new TaggedFriendsData( "208 Friends","Prassanna", "36 Age", ""));
        taggedFriendsDatas.add(new TaggedFriendsData( "80 Friends","Sundar", "32 Age", ""));
        taggedFriendsDatas.add(new TaggedFriendsData( "62 Friends","Kumar", "18 Age", ""));
        return taggedFriendsDatas;
    }
    public void setRecycleList(RecyclerView recycleList,Boolean flag)
    {
        recycleList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        taggedFriendListAdapter=new TaggedFriendListAdapter(this,tagged_friend_dummy_data(),flag);
        recycleList.setAdapter(taggedFriendListAdapter);
        taggedFriendListAdapter.notifyDataSetChanged();
    }
}
