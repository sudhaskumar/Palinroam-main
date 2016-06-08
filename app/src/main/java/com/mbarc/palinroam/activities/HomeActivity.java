package com.mbarc.palinroam.activities;

import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.mbarc.palinroam.R;
import com.mbarc.palinroam.adapter.HomeViewPageAdapter;
import com.mbarc.palinroam.constants.Constants;
import com.mbarc.palinroam.fragments.LoginFragment;
import com.mbarc.palinroam.fragments.SignupFragment;
import com.mbarc.palinroam.util.Utils;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.tabs)TabLayout tabLayout;
    @Bind(R.id.viewpager)ViewPager viewPager;
    @BindString(R.string.login_name)String loginName;
    @BindString(R.string.signup_name)String signupName;
    @Bind(R.id.facebook_login)ImageView facbookLoginButton;
    @Bind(R.id.gplus_login)ImageView gPlusLoginButton;
    @Bind(R.id.twitter_login)ImageView twitterLoginButton;
    HomeViewPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            if(!Utils.isInternetWorking())
            {
                Utils.showToast(HomeActivity.this, Constants.NO_NETWORK);
            }else{
                Log.d("CHECK_INTERNET","Net Connection Is Available");
            }
        }
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        pageAdapter=new HomeViewPageAdapter(getSupportFragmentManager());
        pageAdapter.addFragment(new LoginFragment(),loginName);
        pageAdapter.addFragment(new SignupFragment(),signupName);
        viewPager.setAdapter(pageAdapter);
    }
}
