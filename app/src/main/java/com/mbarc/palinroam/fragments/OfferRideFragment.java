package com.mbarc.palinroam.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.activities.OfferRideActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by sudhas on 5/18/2016.
 */
public class OfferRideFragment extends Fragment {
    @Bind(R.id.offer_ride_leave_from)
    AutoCompleteTextView offerRideLeaveFrom;
    @Bind(R.id.offer_ride_going_to)
    AutoCompleteTextView offerRideGoingTo;
    @Bind(R.id.offer_ride_date)
    EditText offerRideDepDate;
    @Bind(R.id.offer_ride_time)
    EditText offerRideDepTime;
    @Bind(R.id.offer_ride_return_date)
    EditText offerRideRetDate;
    @Bind(R.id.offer_ride_return_time)
    EditText offerRideRetTime;
    @Bind(R.id.round_trip_checkbox)
    AppCompatCheckBox roundTripCheckBox;
    @Bind(R.id.offer_ride_next_button)
    Button nextButton;
    @Bind(R.id.return_timing_layout)
    LinearLayout return_layout;

    @OnClick(R.id.offer_ride_next_button)
    public void nextAction(View view) {
        startActivity(new Intent(getActivity(), OfferRideActivity.class));
    }

    @OnCheckedChanged(R.id.round_trip_checkbox)
    public void returnTripAction(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            return_layout.setVisibility(View.GONE);
        } else {
            return_layout.setVisibility(View.VISIBLE);
        }
    }

    public OfferRideFragment() {
        // empty constractor required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_offerride, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
