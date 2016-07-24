package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.RoutePriceListAdapter;
import com.mbarc.palinroam.data.RoutePriceData;
import com.mbarc.palinroam.data.StopOverData;
import com.mbarc.palinroam.util.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OfferRideActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.agree_checkbox)
    CheckBox agreeCheckbox;
    @Bind(R.id.base_button)
    Button joinButton;

    @OnClick(R.id.base_button)
    public void joinAction() {
        if (!agreeCheckbox.isChecked()) {
            Utils.showToast(OfferRideActivity.this, "Please Accept the Agreement");
        } else {

        }
    }

    @Bind(R.id.co_passanger_group)
    RadioGroup coPassangerGroup;
    @Bind(R.id.ride_certian_group)
    RadioGroup rideCertainGroup;
    @Bind(R.id.policy_group)
    RadioGroup policyGroup;


    @Bind(R.id.stopover_price_list)
    RecyclerView routePriceList;
    int defaultValue = 1;
    @Bind(R.id.no_of_seat_text)
    TextView noOfSeatText;
    @Bind(R.id.seat_minus_button)
    ImageView seatMinusButton;

    @OnClick(R.id.seat_minus_button)
    public void minusAction(View v) {
        if (defaultValue == 0) {
            defaultValue = 1;
        } else {
            defaultValue = defaultValue - 1;
            noOfSeatText.setText(" " + defaultValue);
        }

    }

    @Bind(R.id.seat_plus_button)
    ImageView seatPlusButton;

    @OnClick(R.id.seat_plus_button)
    public void plusAction(View v) {
        defaultValue = defaultValue + 1;
        noOfSeatText.setText(" " + defaultValue);
    }

    RoutePriceListAdapter routePriceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
        ButterKnife.bind(this);
        toolbar.setTitle("Offer A Ride");
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.backarrowicon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        joinButton.setText("Publish Now");
        routePriceList.setLayoutManager(new LinearLayoutManager(this));
        routePriceListAdapter = new RoutePriceListAdapter(OfferRideActivity.this, fill_with_dummy_data());
        routePriceList.setAdapter(routePriceListAdapter);
        routePriceListAdapter.notifyDataSetChanged();

    }

    public List<RoutePriceData> fill_with_dummy_data() {

        List<RoutePriceData> routePriceDatas = new ArrayList<>();
        routePriceDatas.add(new RoutePriceData("Chennai", "Thirchy", 120));
        routePriceDatas.add(new RoutePriceData("Thirchy", "Madurai", 420));
        routePriceDatas.add(new RoutePriceData("Madurai", "Virudhunagar", 220));
        return routePriceDatas;
    }
}
