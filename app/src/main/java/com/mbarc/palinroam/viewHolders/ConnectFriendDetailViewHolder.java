package com.mbarc.palinroam.viewHolders;

import android.content.Context;
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
public class ConnectFriendDetailViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.connect_friend_pro_name)public TextView profileNameTextView;
    @Bind(R.id.connect_friend_pro_age)public TextView profileFriendAge;
    @Bind(R.id.connect_friend_pro_mutuals)public TextView profileFriendMutuals;
    @Bind(R.id.connect_friend_pro_rating)public TextView profileFriendRatings;
    @Bind(R.id.connect_friend_to_add)public ImageView profileFriendFlagType;
    @Bind(R.id.connect_friend_pro_image)public ImageView profileFriendImage;

    public ConnectFriendDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
