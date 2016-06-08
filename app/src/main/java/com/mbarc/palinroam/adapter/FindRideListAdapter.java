package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.anim.AnimationUtils;
import com.mbarc.palinroam.data.FindRideListData;
import com.mbarc.palinroam.viewHolders.FindRideListViewHolder;

import java.util.Collections;
import java.util.List;

import butterknife.BindString;

/**
 * Created by sudhas on 6/3/2016.
 */
public class FindRideListAdapter extends RecyclerView.Adapter<FindRideListViewHolder> {
    Context context;
    List<FindRideListData> findRideList = Collections.emptyList();
    @BindString(R.string.low_certainty) String lowCertainty;
    @BindString(R.string.medium_certainty) String mediumCertainty;
    @BindString(R.string.high_certainty) String highCertainty;
    private int mPreviousPosition = 0;

    public FindRideListAdapter(Context context, List<FindRideListData> findRideList) {
        this.context = context;
        this.findRideList = findRideList;
    }

    @Override
    public FindRideListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem_of_ride_list,parent,false);
        return new FindRideListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FindRideListViewHolder holder, int position) {
        holder.nameTextView.setText(findRideList.get(position).name);
        holder.ageTextView.setText(findRideList.get(position).age);
        holder.amtTextView.setText(findRideList.get(position).amtPerSeat);
        holder.dateTextView.setText(findRideList.get(position).startDate);
        holder.noFriendsTextview.setText(findRideList.get(position).numberOfFriends);
        holder.timeTextView.setText(findRideList.get(position).startTime);
        holder.noMutualFriendsTextView.setText(findRideList.get(position).numberOfMutualFriends);
        holder.certaintyTextView.setText(findRideList.get(position).certaintyType);
        holder.noOfSeatTextView.setText(findRideList.get(position).availableSeat);
        holder.userRatingTextView.setText(findRideList.get(position).userRating);
        if(findRideList.get(position).certaintyType.equalsIgnoreCase(lowCertainty))
        {
            holder.certaintyColorType.setBackgroundColor(ContextCompat.getColor(context, R.color.certain_low));
        }else if(findRideList.get(position).certaintyType.equalsIgnoreCase(mediumCertainty))
        {
            holder.certaintyColorType.setBackgroundColor(ContextCompat.getColor(context, R.color.certain_medium));
        }
        else if(findRideList.get(position).certaintyType.equalsIgnoreCase(highCertainty))
        {
            holder.certaintyColorType.setBackgroundColor(ContextCompat.getColor(context, R.color.certain_high));
        }
        listAnimation(position,holder);

    }

    @Override
    public int getItemCount() {
        return findRideList.size();
    }
    public void listAnimation(int position,FindRideListViewHolder holder){
        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
        } else {
            AnimationUtils.animateSunblind(holder, false);
        }
        mPreviousPosition = position;
    }
}
