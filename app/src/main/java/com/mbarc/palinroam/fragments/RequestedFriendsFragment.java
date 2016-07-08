package com.mbarc.palinroam.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.FriendListAdapter;
import com.mbarc.palinroam.adapter.RequestedListAdapter;
import com.mbarc.palinroam.data.FriendsData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sudhas on 5/18/2016.
 */
public class RequestedFriendsFragment extends Fragment{

    @Nullable
    @Bind(R.id.friends_list)RecyclerView friendsList;
    RequestedListAdapter friendListAdapter;
    public RequestedFriendsFragment() {
        // empty constractor required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_list_of_friends,container,false);
        ButterKnife.bind(this,view);
        friendsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        friendListAdapter = new RequestedListAdapter(getActivity(), fill_with_dummy_data());
        friendsList.setAdapter(friendListAdapter);
        friendListAdapter.notifyDataSetChanged();
        return view;
    }

    public List<FriendsData> fill_with_dummy_data() {

        List<FriendsData> friendsDatas = new ArrayList<>();
        friendsDatas.add(new FriendsData("Sudhaskumar", "24 Age", "216 Mutual Friends", true, "", "4.9"));
        friendsDatas.add(new FriendsData("Nagasundari", "45 Age", "21 Mutual Friends", false, "", "4.4"));
        friendsDatas.add(new FriendsData("Prasanna", "32 Age", "67 Mutual Friends", true, "", "4.0"));
        friendsDatas.add(new FriendsData("Thiyagu", "26 Age", "236 Mutual Friends", true, "", "3.9"));
        friendsDatas.add(new FriendsData("Kumar", "24 Age", "216 Mutual Friends", true, "", "4.9"));
        friendsDatas.add(new FriendsData("Sundari", "45 Age", "21 Mutual Friends", false, "", "4.4"));
        friendsDatas.add(new FriendsData("Prasanna", "32 Age", "67 Mutual Friends", true, "", "4.0"));
        friendsDatas.add(new FriendsData("Thiyagu", "26 Age", "236 Mutual Friends", true, "", "3.9"));
        return friendsDatas;
    }
}
