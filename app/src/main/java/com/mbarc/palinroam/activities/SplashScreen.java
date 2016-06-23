package com.mbarc.palinroam.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.util.SessionManager;
import com.mbarc.palinroam.util.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {
    SessionManager manager;
    @Bind(R.id.login_progress)
    View mProgressView;
    @Bind(R.id.login_form)
    View mLoginFormView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        manager=new SessionManager();
        ButterKnife.bind(SplashScreen.this);
       // Utils.showProgress(true,SplashScreen.this,mProgressView,mLoginFormView);

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 3 seconds
                    sleep(3*1000);

                    // After 5 seconds redirect to another intent
                    String status=manager.getPreferences(SplashScreen.this,"status");
                    Log.d("status",status);
                    if (status.equals("1")){
                       // Utils.showProgress(false,SplashScreen.this,mProgressView,mLoginFormView);
                        Intent i=new Intent(SplashScreen.this,WelcomePage.class);
                        startActivity(i);
                    }else{
                      //  Utils.showProgress(false,SplashScreen.this,mProgressView,mLoginFormView);
                        Intent i=new Intent(SplashScreen.this,HomeActivity.class);
                        startActivity(i);
                    }





                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
