package com.mbarc.palinroam.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mbarc.palinroam.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Admin on 6/3/2016.
 */
public class RoutePriceViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.route_city_name)public TextView ciryRouteName;
    @Bind(R.id.minus_button)public Button minusButton;
    @Bind(R.id.plus_button)public Button plusButton;
    @Bind(R.id.route_price)public TextView routePrice;

    public RoutePriceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
