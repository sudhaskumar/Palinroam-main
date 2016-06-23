package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.ConnectFriendsData;
import com.mbarc.palinroam.data.TaggedFriendsData;
import com.mbarc.palinroam.viewHolders.ConnectFriendDetailViewHolder;
import com.mbarc.palinroam.viewHolders.TaggedFriendDetailViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class TaggedFriendListAdapter extends RecyclerView.Adapter<TaggedFriendDetailViewHolder> {
    Context context;
    List<TaggedFriendsData> taggedFriendsDataList = Collections.emptyList();
    Boolean viewFlag;

    public TaggedFriendListAdapter(Context context, List<TaggedFriendsData> taggedFriendsDataList,Boolean viewFlag) {
        this.context = context;
        this.taggedFriendsDataList = taggedFriendsDataList;
        this.viewFlag=viewFlag;
    }

    @Override
    public TaggedFriendDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem_of_tagged_friends, parent, false);
        return new TaggedFriendDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TaggedFriendDetailViewHolder holder, final int position) {
        holder.profileNameTextView.setText(taggedFriendsDataList.get(position).taggedFriendName);
        holder.profileFriendAge.setText(taggedFriendsDataList.get(position).taggedtFriendAge);
        holder.profileFriendMutuals.setText(taggedFriendsDataList.get(position).taggedFriendNoOfFriends);


        if (viewFlag) {
            holder.deleteTaggedFriendImage.setVisibility(View.VISIBLE);
        } else {
            holder.deleteTaggedFriendImage.setVisibility(View.GONE);
        }
        holder.deleteTaggedFriendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taggedFriendsDataList.remove(holder.getPosition());
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return taggedFriendsDataList.size();
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
