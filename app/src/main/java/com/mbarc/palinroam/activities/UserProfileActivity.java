package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.ConnectFriendListAdapter;
import com.mbarc.palinroam.data.ConnectFriendsData;
import com.mbarc.palinroam.data.FindRideListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProfileActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.connect_friends_detail_list)
    RecyclerView connectFriendDetailList;
    @Bind(R.id.edit_profile_layout)
    LinearLayout editProfileLayout;
    @OnClick(R.id.edit_profile_layout)
    public void editAction() {
        startActivity(new Intent(UserProfileActivity.this, AboutActivity.class));
    }

    ConnectFriendListAdapter connectFriendListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.navication));
        connectFriendDetailList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        connectFriendListAdapter = new ConnectFriendListAdapter(UserProfileActivity.this, fill_with_data());
        connectFriendDetailList.setAdapter(connectFriendListAdapter);
        connectFriendListAdapter.notifyDataSetChanged();
    }

    public List<ConnectFriendsData> fill_with_data() {

        List<ConnectFriendsData> connectFriendsDatas = new ArrayList<>();
        connectFriendsDatas.add(new ConnectFriendsData("Sudhaskumar", "24 Age", "216 Mutual Friends", true, "", "4.9"));
        connectFriendsDatas.add(new ConnectFriendsData("Nagasundari", "45 Age", "21 Mutual Friends", false, "", "4.4"));
        connectFriendsDatas.add(new ConnectFriendsData("Prasanna", "32 Age", "67 Mutual Friends", true, "", "4.0"));
        connectFriendsDatas.add(new ConnectFriendsData("Thiyagu", "26 Age", "236 Mutual Friends", true, "", "3.9"));
        return connectFriendsDatas;
    }
}
