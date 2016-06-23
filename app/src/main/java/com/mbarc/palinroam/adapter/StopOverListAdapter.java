package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.ConnectFriendsData;
import com.mbarc.palinroam.data.StopOverData;
import com.mbarc.palinroam.viewHolders.ConnectFriendDetailViewHolder;
import com.mbarc.palinroam.viewHolders.StopOverListViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class StopOverListAdapter extends RecyclerView.Adapter<StopOverListViewHolder> {
    Context context;
    List<StopOverData> stopOverDataList = Collections.emptyList();

    public StopOverListAdapter(Context context, List<StopOverData> stopOverDataList) {
        this.context = context;
        this.stopOverDataList = stopOverDataList;
    }

    @Override
    public StopOverListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_of_stopover_view, parent, false);
        return new StopOverListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StopOverListViewHolder holder, int position) {
        holder.sourcePointView.setText(stopOverDataList.get(position).sourceName);
        holder.destinationPointView.setText(stopOverDataList.get(position).destinationName);
        holder.amountView.setText(stopOverDataList.get(position).rateOfAmt);
        holder.kmsView.setText("("+ stopOverDataList.get(position).kmsCount +" Km)");


    }

    @Override
    public int getItemCount() {
        return stopOverDataList.size();
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
