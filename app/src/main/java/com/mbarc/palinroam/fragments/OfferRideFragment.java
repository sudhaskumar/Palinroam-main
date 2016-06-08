package com.mbarc.palinroam.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mbarc.palinroam.R;

/**
 * Created by sudhas on 5/18/2016.
 */
public class OfferRideFragment extends Fragment{

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

        return inflater.inflate(R.layout.fragment_offerride,container,false);
    }
}
