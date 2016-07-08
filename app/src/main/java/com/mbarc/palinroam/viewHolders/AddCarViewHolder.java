package com.mbarc.palinroam.viewHolders;

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
public class AddCarViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.car_name)public TextView carNameTextView;
    @Bind(R.id.car_color)public TextView carColorTextView;
    @Bind(R.id.car_desc)public TextView carDescriptionTextView;
    @Bind(R.id.car_image)public ImageView carImage;

    public AddCarViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
