package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.AddStopOverData;
import com.mbarc.palinroam.data.RoutePriceData;
import com.mbarc.palinroam.viewHolders.AddingStopOverViewHolder;
import com.mbarc.palinroam.viewHolders.RoutePriceViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class AddingStopOverListAdapter extends RecyclerView.Adapter<AddingStopOverViewHolder> {
    Context context;
    List<AddStopOverData> addStopOverDataList = Collections.emptyList();

    public AddingStopOverListAdapter(Context context, List<AddStopOverData> addStopOverDataList) {
        this.context = context;
        this.addStopOverDataList = addStopOverDataList;
    }

    @Override
    public AddingStopOverViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_of_adding_stopover, parent, false);
        return new AddingStopOverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AddingStopOverViewHolder holder, final int position) {
        holder.stopOverCityName.setText(addStopOverDataList.get(position).stopOverCityNameText);
        holder.stopOverRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStopOverDataList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return addStopOverDataList.size();
    }

}
