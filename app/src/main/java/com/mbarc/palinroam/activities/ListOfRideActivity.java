package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.FindRideListAdapter;
import com.mbarc.palinroam.data.FindRideListData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListOfRideActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)Toolbar toolbar ;
    @Bind(R.id.recycleview_list_of_ride)RecyclerView listOfRide;
    @Bind(R.id.fab) FloatingActionButton filterButton;
    @BindString(R.string.high_certainty) String highCertainty;
    @BindString(R.string.low_certainty) String lowCertainty;
    @BindString(R.string.medium_certainty) String mediumCertainty;
    @OnClick(R.id.fab)
    public void filterAction(View view)
    {
        startActivity(new Intent(ListOfRideActivity.this,FilterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_ride);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        listOfRide.setLayoutManager(new LinearLayoutManager(this));
        FindRideListAdapter findRideListAdapter=new FindRideListAdapter(ListOfRideActivity.this,fill_with_data());
        listOfRide.setAdapter(findRideListAdapter);
        findRideListAdapter.notifyDataSetChanged();

    }

    public List<FindRideListData> fill_with_data() {

        List<FindRideListData> findRideListData = new ArrayList<>();
        findRideListData.add(new FindRideListData("Sudhaskumar","24 Age","216 Friends","34 Mutual","500","Fri 16 Jul","05:45 pm","4.9","3 Seat",highCertainty));
        findRideListData.add(new FindRideListData("Nagasundari","45 Age","21 Friends","12 Mutual","300","Tus 3 May","06:45 pm","4.4","2 Seat",lowCertainty));
        findRideListData.add(new FindRideListData("Prasanna","32 Age","142 Friends","67 Mutual","700","Mon 7 Feb","09:45 pm","4.0","3 Seat",highCertainty));
        findRideListData.add(new FindRideListData("Thiyagu","26 Age","236 Friends","4 Mutual","600","Fri 6 Jul","05:45 pm","3.9","1 Seat",mediumCertainty));
        findRideListData.add(new FindRideListData("Visu","22 Age","265 Friends","24 Mutual","500","Fri 3 Aug","07:45 am","4.5","3 Seat",highCertainty));
        findRideListData.add(new FindRideListData("Suganya","24 Age","216 Friends","34 Mutual","500","Fri 16 Jul","05:45 pm","4.9","3 Seat",mediumCertainty));
        findRideListData.add(new FindRideListData("Renu","24 Age","216 Friends","34 Mutual","500","Fri 16 Jul","05:45 pm","4.9","3 Seat",mediumCertainty));
        findRideListData.add(new FindRideListData("Kumar","24 Age","216 Friends","34 Mutual","500","Fri 16 Jul","05:45 pm","4.9","3 Seat",lowCertainty));
        findRideListData.add(new FindRideListData("Rajan","24 Age","216 Friends","34 Mutual","500","Fri 16 Jul","05:45 pm","4.9","3 Seat",highCertainty));
        return findRideListData;
    }
}
