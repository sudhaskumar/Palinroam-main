package com.mbarc.palinroam.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.AddCarListAdapter;
import com.mbarc.palinroam.data.AddCarData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddCarActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recycleview_add_car)
    RecyclerView addCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        ButterKnife.bind(this);
        toolbar.setTitle("Add Car");
        toolbar.setTitleTextColor((getResources().getColor(R.color.icons)));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.backarrowicon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        addCar.setLayoutManager(new LinearLayoutManager(this));
        AddCarListAdapter addCarListAdapter = new AddCarListAdapter(AddCarActivity.this,fill_with_dummy_data());
        addCar.setAdapter(addCarListAdapter);
        addCarListAdapter.notifyDataSetChanged();
    }
    public List<AddCarData> fill_with_dummy_data() {

        List<AddCarData> addCarDatas = new ArrayList<>();
        addCarDatas.add(new AddCarData("Swift", "Red", "Air conditioned",""));
        addCarDatas.add(new AddCarData("Alto", "White", "Air conditioned",""));
        return addCarDatas;
    }
}
