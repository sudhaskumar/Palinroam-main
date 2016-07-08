package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mbarc.palinroam.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThankingPageActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.base_button)Button joinButton;
    @OnClick(R.id.base_button)
    public void joinAction()
    {
        startActivity(new Intent(ThankingPageActivity.this,ListOfRideActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanking_page);
        ButterKnife.bind(this);
        toolbar.setTitle( "Find a ride" );
        toolbar.setTitleTextColor(getResources().getColor(R.color.icons));
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.backarrowicon));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThankingPageActivity.this,FindRideActivity.class));
            }
        });
        joinButton.setText("See similar rides");
    }
}
