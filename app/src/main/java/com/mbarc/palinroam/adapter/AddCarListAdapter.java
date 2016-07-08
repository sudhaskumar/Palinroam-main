package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.AddCarData;
import com.mbarc.palinroam.data.FriendsData;
import com.mbarc.palinroam.viewHolders.AddCarViewHolder;
import com.mbarc.palinroam.viewHolders.FriendDetailViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class AddCarListAdapter extends RecyclerView.Adapter<AddCarViewHolder> {
    Context context;
    List<AddCarData> addCarDataList = Collections.emptyList();

    public AddCarListAdapter(Context context, List<AddCarData> addCarDataList) {
        this.context = context;
        this.addCarDataList = addCarDataList;
    }

    @Override
    public AddCarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleitem_of_add_car, parent, false);
        return new AddCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddCarViewHolder holder, int position) {
        holder.carNameTextView.setText(addCarDataList.get(position).carName);
        holder.carColorTextView.setText(addCarDataList.get(position).carColor);
        holder.carDescriptionTextView.setText(addCarDataList.get(position).carDesc);


//        if (!friendDataList.get(position).connectFriendFlag) {
//            holder.profileFriendFlagType.setImageResource(R.mipmap.alreadyfriendicon);
//        } else {
//            holder.profileFriendFlagType.setImageResource(R.mipmap.addfriendsicon);
//        }

    }

    @Override
    public int getItemCount() {
        return addCarDataList.size();
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
