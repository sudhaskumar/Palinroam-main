package com.mbarc.palinroam.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mbarc.palinroam.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Admin on 6/3/2016.
 */
public class FindRideListViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.sirl_name)public TextView nameTextView;
    @Bind(R.id.sirl_age)public TextView ageTextView;
    @Bind(R.id.sirl_date)public TextView dateTextView;
    @Bind(R.id.sirl_time)public TextView timeTextView;
    @Bind(R.id.sirl_amt)public TextView amtTextView;
    @Bind(R.id.sirl_certainty_type)public TextView certaintyTextView;
    @Bind(R.id.sirl_no_friends)public TextView noFriendsTextview;
    @Bind(R.id.sirl_no_mutual_friends)public TextView noMutualFriendsTextView;
    @Bind(R.id.sirl_no_of_seats)public TextView noOfSeatTextView;
    @Bind(R.id.sirl_user_rating)public TextView userRatingTextView;
    @Bind(R.id.sirl_certainty_color)public ImageView certaintyColorType;

    public FindRideListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
