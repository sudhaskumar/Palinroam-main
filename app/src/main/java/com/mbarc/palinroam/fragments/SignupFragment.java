package com.mbarc.palinroam.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.mbarc.palinroam.R;
import com.mbarc.palinroam.activities.FindRideActivity;
import com.mbarc.palinroam.activities.UserProfileActivity;
import com.mbarc.palinroam.constants.Constants;
import com.mbarc.palinroam.util.BaseRequest;
import com.mbarc.palinroam.util.JsonObjectBulider;
import com.mbarc.palinroam.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by sudhas on 5/18/2016.
 */
public class SignupFragment extends Fragment{
    @Bind(R.id.signup_progress) View mProgressView;
    @Bind(R.id.signup_form) View mSignUpFormView;
    @Bind(R.id.sign_username) EditText signUpUserName;
    @Bind(R.id.sign_email) EditText signUpEmail;
    @Bind(R.id.sign_password)EditText signUpPassword;
    @Bind(R.id.sign_confirm_password) EditText signUpConfirmPassword;
    @Bind(R.id.sign_up_button)Button signUpButton;
    @OnClick(R.id.sign_up_button)
    public void signUp(){
        Utils.showProgress(true,getActivity(),mProgressView,mSignUpFormView);
        attemptSignUp(signUpUserName.getText().toString(),signUpEmail.getText().toString(),signUpPassword.getText().toString(),Utils.getIpAddress(),Utils.getDeviceId(getActivity()));
    }

    RequestQueue requestQueue;
    public SignupFragment() {
        // empty constractor required
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        ButterKnife.bind(this,view);
        requestQueue= Volley.newRequestQueue(getActivity());
        return view;
    }
    public void attemptSignUp(String userName,String emailId,String password,String ipAddress,String deviceId){
        JSONObject params= null;
        try {
            params = new JSONObject().put("BigHiveRegistrationRequest",new JSONObject().put("requestId",null)
                    .put("userCred", JsonObjectBulider.userCredantials(emailId,password,JsonObjectBulider.sessionDetails(null,ipAddress,deviceId)))
                    .put("personName",new JSONObject().put("PersonName",JsonObjectBulider.personNameDetails(userName,null,null,null))));
            Log.d("REG_PARAMETERS",params.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestQueue.add(new BaseRequest(Request.Method.POST, Constants.MAINURL + Constants.REGISTERATION_METHOD, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response.toString().contains("SUCCESS"))
                {
                    Utils.showProgress(false,getActivity(),mProgressView,mSignUpFormView);
                    Utils.showToast(getActivity(),"Registration Successfully");
                }
                Log.d("REGISTRATION_ERROR",response.toString());
                Utils.showProgress(false,getActivity(),mProgressView,mSignUpFormView);
                startActivity(new Intent(getActivity(), UserProfileActivity.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showProgress(false,getActivity(),mProgressView,mSignUpFormView);
                Log.d("REGISTRATION_ERROR",error.toString());
            }
        }));
    }
}
