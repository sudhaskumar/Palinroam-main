package com.mbarc.palinroam.viewHolders;

import android.support.annotation.Nullable;
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
public class TaggedFriendDetailViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.tagged_friend_pro_name)
    public TextView profileNameTextView;
    @Bind(R.id.tagged_friend_pro_age)
    public TextView profileFriendAge;
    @Bind(R.id.tagged_friend_pro_friends)
    public TextView profileFriendMutuals;
    @Bind(R.id.tagged_friend_pro_image)
    public ImageView profileFriendImage;
    @Bind(R.id.delete_tagged_image)
    public ImageView deleteTaggedFriendImage;

    public TaggedFriendDetailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
