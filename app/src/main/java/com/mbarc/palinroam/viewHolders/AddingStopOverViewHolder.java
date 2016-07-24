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
 * Created by Admin on 6/3/2016.
 */
public class AddingStopOverViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.stopover_city_name)
    public TextView stopOverCityName;
    @Bind(R.id.stopover_remove_button)
    public ImageView stopOverRemoveButton;



    public AddingStopOverViewHolder(View itemView) {
        super(itemView);
        try{
            ButterKnife.bind(this, itemView);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
