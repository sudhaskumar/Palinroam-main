package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.constants.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomePage extends AppCompatActivity {
    @Bind(R.id.welcome_page_verify_button)
    Button welcomePageVerifyButton;
    @OnClick(R.id.welcome_page_verify_button)
    public void verifyAction()
    {
        startActivity(new Intent(WelcomePage.this,FindRideActivity.class));
    }
    String userName;
    @Bind(R.id.user_welcome_text)
    TextView userWelcomeText;
    @Bind(R.id.send_otp)
    Button sendotp;

    @OnClick(R.id.send_otp)
    public void sendotpmethod()
    {
        startActivity(new Intent(WelcomePage.this,AddCarActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        ButterKnife.bind(WelcomePage.this);
        SharedPreferences prefs = getSharedPreferences(Constants.GET_USER_PROFILE, MODE_PRIVATE);
        userName = prefs.getString("username", null);
        userWelcomeText.setText("Welcome "+ userName +" !");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
