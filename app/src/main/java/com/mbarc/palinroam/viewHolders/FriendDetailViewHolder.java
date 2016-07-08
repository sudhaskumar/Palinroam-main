package com.mbarc.palinroam.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbarc.palinroam.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sudhas on 6/3/2016.
 */
public class FriendDetailViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.friend_name)public TextView friendNameTextView;
    @Bind(R.id.friend_age)public TextView friendFriendAge;
    @Bind(R.id.friend_mutuals)public TextView friendFriendMutuals;
    @Bind(R.id.friend_rating)public TextView friendFriendRatings;
    @Bind(R.id.already_friend_image)public ImageView friendFlagType;
    @Bind(R.id.friend_profile_image)public ImageView friendProfileImage;

    public FriendDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
