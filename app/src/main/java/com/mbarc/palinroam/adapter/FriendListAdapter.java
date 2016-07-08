package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.ConnectFriendsData;
import com.mbarc.palinroam.data.FriendsData;
import com.mbarc.palinroam.viewHolders.ConnectFriendDetailViewHolder;
import com.mbarc.palinroam.viewHolders.FriendDetailViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class FriendListAdapter extends RecyclerView.Adapter<FriendDetailViewHolder> {
    Context context;
    List<FriendsData> friendDataList = Collections.emptyList();

    public FriendListAdapter(Context context, List<FriendsData> friendDataList) {
        this.context = context;
        this.friendDataList = friendDataList;
    }

    @Override
    public FriendDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem_of_friends_list, parent, false);
        return new FriendDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendDetailViewHolder holder, int position) {
        holder.friendNameTextView.setText(friendDataList.get(position).friendName);
        holder.friendFriendAge.setText(friendDataList.get(position).friendAge);
        holder.friendFriendMutuals.setText(friendDataList.get(position).friendNoOfMutuals);
        holder.friendFriendRatings.setText(friendDataList.get(position).friendRatings);

//        if (!friendDataList.get(position).connectFriendFlag) {
//            holder.profileFriendFlagType.setImageResource(R.mipmap.alreadyfriendicon);
//        } else {
//            holder.profileFriendFlagType.setImageResource(R.mipmap.addfriendsicon);
//        }

    }

    @Override
    public int getItemCount() {
        return friendDataList.size();
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
