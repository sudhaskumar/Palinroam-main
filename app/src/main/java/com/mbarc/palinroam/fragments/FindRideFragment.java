package com.mbarc.palinroam.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.mbarc.palinroam.R;
import com.mbarc.palinroam.activities.ListOfRideActivity;
import com.mbarc.palinroam.adapter.GooglePlaceApiAdapter;
import com.mbarc.palinroam.util.SetDatePicker;
import com.mbarc.palinroam.util.SetTimePicker;
import com.mbarc.palinroam.util.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by sudhas on 5/18/2016.
 */
public class FindRideFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks {
    @Nullable
    @Bind(R.id.leave_from)
    AutoCompleteTextView leavingFromAutoComplete;
    //        @OnItemClick(R.id.leave_from)
//    public void leavingFromClickAction(AdapterView<?> parent, View view, int position, long id)
//    {
//        final GooglePlaceApiAdapter.PlaceAutocomplete item=googlePlaceApiAdapter.getItem(position);
//        final String placeId = String.valueOf(item.placeId);
//        Log.i(LOG_TAG, "Selected: " + item.description);
//        PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
//                .getPlaceById(mGoogleApiClient, placeId);
//        placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
//        Log.i(LOG_TAG, "Fetching details for ID: " + item.placeId);
//    }
    @Nullable
    @Bind(R.id.going_to)
    AutoCompleteTextView goingToAutoComplete;
    //    @OnItemClick(R.id.going_to)
//    public void goingToClickAction(AdapterView<?> parent, View view, int position, long id)
//    {
//        final GooglePlaceApiAdapter.PlaceAutocomplete item=googlePlaceApiAdapter.getItem(position);
//        final String placeId = String.valueOf(item.placeId);
//        Log.i(LOG_TAG, "Selected: " + item.description);
//        PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
//                .getPlaceById(mGoogleApiClient, placeId);
//        placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
//        Log.i(LOG_TAG, "Fetching details for ID: " + item.placeId);
//    }
    @Nullable
    @Bind(R.id.find_ride_date)
    EditText findRideDate;
    @Nullable
    @Bind(R.id.find_ride_time)
    EditText findRideTime;
    @Nullable
    @Bind(R.id.find_ride_button)
    Button findRideButton;

    @OnClick(R.id.find_ride_button)
    public void findRideAction(View view) {
        startActivity(new Intent(getActivity(), ListOfRideActivity.class));
    }

    private static final String LOG_TAG = "FindRideFragment";
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private GoogleApiClient mGoogleApiClient;
    private GooglePlaceApiAdapter googlePlaceApiAdapter;
    private static final LatLngBounds INDIA_VIEW = new LatLngBounds(
            new LatLng(8.0883064, 77.5384507), new LatLng(10.0883064, 88.5384507));

    public FindRideFragment() {
        // empty constractor required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_findride, container, false);
        ButterKnife.bind(this, view);
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(getActivity(), GOOGLE_API_CLIENT_ID, this)
                .addConnectionCallbacks(this)
                .build();
        assert leavingFromAutoComplete != null;
        leavingFromAutoComplete.setThreshold(3);
        assert goingToAutoComplete != null;
        goingToAutoComplete.setThreshold(3);
        googlePlaceApiAdapter = new GooglePlaceApiAdapter(getActivity(), android.R.layout.simple_list_item_1,
                INDIA_VIEW, null);
        goingToAutoComplete.setAdapter(googlePlaceApiAdapter);
        leavingFromAutoComplete.setAdapter(googlePlaceApiAdapter);
        new SetDatePicker(getActivity(), findRideDate);
        new SetTimePicker(getActivity(), findRideTime);
        return view;
    }

    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(@NonNull PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                Log.e(LOG_TAG, "Place query did not complete. Error: " +
                        places.getStatus().toString());
                return;
            }
            // Selecting the first object buffer.
            final Place place = places.get(0);
            CharSequence attributions = places.getAttributions();

        }
    };


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        googlePlaceApiAdapter.setGoogleApiClient(mGoogleApiClient);
        Log.i(LOG_TAG, "Google Places API connected.");
    }

    @Override
    public void onConnectionSuspended(int i) {
        googlePlaceApiAdapter.setGoogleApiClient(null);
        Log.e(LOG_TAG, "Google Places API connection suspended.");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(LOG_TAG, "Google Places API connection failed with error code: "
                + connectionResult.getErrorCode());

        Toast.makeText(getActivity(),
                "Google Places API connection failed with error code:" +
                        connectionResult.getErrorCode(),
                Toast.LENGTH_LONG).show();
    }
}
