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
public class StopOverListViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.source_point_text_view)public TextView sourcePointView;
    @Bind(R.id.destination_point_text)public TextView destinationPointView;
    @Bind(R.id.rate_per_person_text_view)public TextView amountView;
    @Bind(R.id.kms_text_view)public TextView kmsView;

    public StopOverListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
