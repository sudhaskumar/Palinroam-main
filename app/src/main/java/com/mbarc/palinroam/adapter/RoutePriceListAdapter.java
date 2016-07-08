package com.mbarc.palinroam.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.data.RoutePriceData;
import com.mbarc.palinroam.data.StopOverData;
import com.mbarc.palinroam.viewHolders.RoutePriceViewHolder;
import com.mbarc.palinroam.viewHolders.StopOverListViewHolder;

import java.util.Collections;
import java.util.List;


/**
 * Created by sudhas on 6/3/2016.
 */
public class RoutePriceListAdapter extends RecyclerView.Adapter<RoutePriceViewHolder> {
    Context context;
    List<RoutePriceData> routePriceDataList = Collections.emptyList();
    public int normalAmt = 0;

    public RoutePriceListAdapter(Context context, List<RoutePriceData> routePriceDataList) {
        this.context = context;
        this.routePriceDataList = routePriceDataList;
    }

    @Override
    public RoutePriceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item_price_list, parent, false);
        return new RoutePriceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RoutePriceViewHolder holder, final int position) {
        holder.ciryRouteName.setText(routePriceDataList.get(position).sourceCity + " to \n " + routePriceDataList.get(position).destinationCity);
        holder.routePrice.setText(" " + routePriceDataList.get(position).routeAmount);
        normalAmt = routePriceDataList.get(position).routeAmount;
        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normalAmt = normalAmt + 10;
                holder.routePrice.setText(" " + normalAmt);
                getRideAmtTextColor(holder.routePrice, routePriceDataList.get(position).routeAmount, normalAmt);
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(normalAmt<0)
                {
                    normalAmt=0;
                    holder.routePrice.setText(" " + normalAmt);
                    getRideAmtTextColor(holder.routePrice, routePriceDataList.get(position).routeAmount, normalAmt);
                }
                if (normalAmt > 0) {
                    normalAmt = normalAmt - 10;
                    holder.routePrice.setText(" " + normalAmt);
                    getRideAmtTextColor(holder.routePrice, routePriceDataList.get(position).routeAmount, normalAmt);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return routePriceDataList.size();
    }

    public void getRideAmtTextColor(TextView textView, int detfalutAmt, int currentAmt) {
        if (detfalutAmt < currentAmt) {
            textView.setTextColor(context.getResources().getColor(R.color.certain_low));
        } else if (detfalutAmt > normalAmt) {
            textView.setTextColor(context.getResources().getColor(R.color.certain_high));
        } else {
            textView.setTextColor(context.getResources().getColor(R.color.certain_medium));
        }
    }
}
