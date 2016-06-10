package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.ConnectFriendsData;
import com.mbarc.palinroam.viewHolders.ConnectFriendDetailViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class ConnectFriendListAdapter extends RecyclerView.Adapter<ConnectFriendDetailViewHolder> {
    Context context;
    List<ConnectFriendsData> connectFriendDataList = Collections.emptyList();

    public ConnectFriendListAdapter(Context context, List<ConnectFriendsData> connectFriendDataList) {
        this.context = context;
        this.connectFriendDataList = connectFriendDataList;
    }

    @Override
    public ConnectFriendDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem_of_connect_friends, parent, false);
        return new ConnectFriendDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConnectFriendDetailViewHolder holder, int position) {
        holder.profileNameTextView.setText(connectFriendDataList.get(position).connectFriendName);
        holder.profileFriendAge.setText(connectFriendDataList.get(position).connectFriendAge);
        holder.profileFriendMutuals.setText(connectFriendDataList.get(position).connectFriendNoOfMutuals);
        holder.profileFriendRatings.setText(connectFriendDataList.get(position).connectFriendRatings);

        if (!connectFriendDataList.get(position).connectFriendFlag) {
            holder.profileFriendFlagType.setImageResource(R.mipmap.alreadyfriendicon);
        } else {
            holder.profileFriendFlagType.setImageResource(R.mipmap.addfriendsicon);
        }

    }

    @Override
    public int getItemCount() {
        return connectFriendDataList.size();
    }
//    public void listAnimation(int position,FindRideListViewHolder holder){
//        if (position > mPreviousPosition) {
//            AnimationUtils.animateSunblind(holder, true);
//        } else {
//            AnimationUtils.animateSunblind(holder, false);
//        }
//        mPreviousPosition = position;
//    }
}
