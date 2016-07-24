package com.mbarc.palinroam.fragments;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.LoaderManager.LoaderCallbacks;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.mbarc.palinroam.R;
import com.mbarc.palinroam.activities.AddingNewCarActivity;
import com.mbarc.palinroam.activities.FindRideActivity;
import com.mbarc.palinroam.activities.ListOfRideActivity;
import com.mbarc.palinroam.activities.WelcomePage;
import com.mbarc.palinroam.constants.Constants;
import com.mbarc.palinroam.util.BaseRequest;
import com.mbarc.palinroam.util.JsonObjectBulider;
import com.mbarc.palinroam.util.SessionManager;
import com.mbarc.palinroam.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

/**
 * Created by sudhas on 5/18/2016.
 */
public class LoginFragment extends Fragment implements LoaderCallbacks<Cursor> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
    };

    @Bind(R.id.login_progress)
    View mProgressView;
    @Bind(R.id.login_form)
    View mLoginFormView;
    @Bind(R.id.email)
    AutoCompleteTextView emailAutoCompleteTextView;
    @Bind(R.id.password)
    EditText passwordEditText;
    RequestQueue requestQueue;
    SessionManager manager;
    Bundle bundle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @OnEditorAction(R.id.password)
    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
        if (id == R.id.login || id == EditorInfo.IME_NULL) {
            attemptLogin();
            return true;
        }
        return false;
    }

    @OnClick(R.id.email_sign_in_button)
    public void login(View view) {
        attemptLogin();
    }

    public LoginFragment() {
        // empty constractor required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        requestQueue = Volley.newRequestQueue(getActivity());
        manager=new SessionManager();
        populateAutoComplete();
        return view;
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        // Retrieve data rows for the device user's 'profile' contact.
        return new CursorLoader(getActivity(),
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");


    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);

    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        emailAutoCompleteTextView.setAdapter(adapter);
    }


    @Override
    public void onLoaderReset(Loader loader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        getActivity().getLoaderManager().initLoader(0, null, this);
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
            Snackbar.make(emailAutoCompleteTextView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, Constants.REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, Constants.REQUEST_READ_CONTACTS);
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == Constants.REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        emailAutoCompleteTextView.setError(null);
        passwordEditText.setError(null);

        // Store values at the time of the login attempt.
        String email = emailAutoCompleteTextView.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailAutoCompleteTextView.setError(getString(R.string.error_field_required));
            focusView = emailAutoCompleteTextView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailAutoCompleteTextView.setError(getString(R.string.error_invalid_email));
            focusView = emailAutoCompleteTextView;
            cancel = true;
        } else if (!isPasswordValid(password)) {
            passwordEditText.setError(getString(R.string.error_invalid_password));
            focusView = passwordEditText;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
            startActivity(new Intent(getActivity(), AddingNewCarActivity.class));
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            Utils.showProgress(true, getActivity(), mProgressView, mLoginFormView);
            authenticateUser(email, password, Utils.getIpAddress(), Utils.getDeviceId(getActivity()));
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    public void authenticateUser(String email, String password, String ipAddress, String deviceId) {

        JSONObject params = null;
        try {
            params = new JSONObject().put("BigHiveLoginRequest", new JSONObject().put("requestId", null)
                    .put("userCred", JsonObjectBulider.userCredantials(email, password, JsonObjectBulider.sessionDetails(null, ipAddress, deviceId))));
            Log.d("REG_PARAMETERS", params.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestQueue.add(new BaseRequest(Request.Method.POST, Constants.MAINURL + Constants.LOGIN_METHOD, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String errorCode=response.getJSONObject("BigHiveLoginResponse").getJSONObject("error").getString("errorCode");
                    String errorMsg=response.getJSONObject("BigHiveLoginResponse").getJSONObject("error").getString("errorMessage");

                    if(errorCode.equalsIgnoreCase("0")){
                        Utils.showProgress(false, getActivity(), mProgressView, mLoginFormView);
                         manager.setPreferences(getActivity(), "status", "1");
                        String status=manager.getPreferences(getActivity(),"status");
                        sharedPreferences =getActivity().getSharedPreferences(Constants.GET_USER_PROFILE, Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        editor.putString("username",response.getJSONObject("BigHiveLoginResponse").getJSONObject("userDetails").getJSONObject("BigHiveUser").getJSONObject("personName").getJSONObject("PersonName").getString("firstName"));
                        editor.apply();
                        Log.d("status", status);
                        Intent intent = new Intent(getActivity(), WelcomePage.class);
                        startActivity(intent);
                       // Utils.showToast(getActivity(), "Login Successfully");

                    } else {
                        Utils.showProgress(false, getActivity(), mProgressView, mLoginFormView);
                        Log.d("REGISTRATION_ERROR", response.toString());
                        Utils.showToast(getActivity(),errorMsg);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.showProgress(false, getActivity(), mProgressView, mLoginFormView);
                Log.d("REGISTRATION_ERROR", error.toString());

            }
        }));
    }


}



