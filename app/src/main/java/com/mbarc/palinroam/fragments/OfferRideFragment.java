package com.mbarc.palinroam.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.mbarc.palinroam.R;
import com.mbarc.palinroam.activities.OfferRideActivity;
import com.mbarc.palinroam.adapter.AddingStopOverListAdapter;
import com.mbarc.palinroam.adapter.GooglePlaceApiAdapter;
import com.mbarc.palinroam.constants.Constants;
import com.mbarc.palinroam.data.AddStopOverData;
import com.mbarc.palinroam.interfaces.VolleyCallback;
import com.mbarc.palinroam.util.BaseRequest;
import com.mbarc.palinroam.util.SetDatePicker;
import com.mbarc.palinroam.util.SetTimePicker;
import com.mbarc.palinroam.util.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by sudhas on 5/18/2016.
 */
public class OfferRideFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks {
    @Bind(R.id.offer_ride_leave_from)
    AutoCompleteTextView offerRideLeaveFrom;
    @Bind(R.id.offer_ride_going_to)
    AutoCompleteTextView offerRideGoingTo;
    @Bind(R.id.offer_ride_stopover)
    AutoCompleteTextView offerRideStopOver;
    @Bind(R.id.offer_ride_date)
    EditText offerRideDepDate;
    @Bind(R.id.offer_ride_time)
    EditText offerRideDepTime;
    @Bind(R.id.offer_ride_return_date)
    EditText offerRideRetDate;
    @Bind(R.id.offer_ride_return_time)
    EditText offerRideRetTime;
    @Bind(R.id.round_trip_checkbox)
    AppCompatCheckBox roundTripCheckBox;
    @Bind(R.id.offer_ride_next_button)
    Button nextButton;
    @Bind(R.id.return_timing_layout)
    LinearLayout return_layout;
    @Bind(R.id.list_of_place)
    LinearLayout stopover_place_layout;
    @Bind(R.id.adding_stopover_list)
    RecyclerView addingStopOverList;
    AddingStopOverListAdapter addingStopOverListAdapter;
    List<AddStopOverData> addingPlace = new ArrayList<AddStopOverData>();
    private static final String LOG_TAG = "OfferRideFragment";
    private static final int GOOGLE_API_CLIENT_ID = 1;
    private GoogleApiClient mGoogleApiClient;
    public Boolean roundTripResult;
    public String userId;
    public String distance, distance2;
    public String sourcePlaceId, distinationPlaceId;
    private GooglePlaceApiAdapter googlePlaceApiAdapter;
    private static final LatLngBounds INDIA_VIEW = new LatLngBounds(
            new LatLng(8.0883064, 77.5384507), new LatLng(10.0883064, 88.5384507));
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RequestQueue requestQueue;

    @OnClick(R.id.offer_ride_next_button)
    public void nextAction(View view) {
        validateFields();
    }

    @OnCheckedChanged(R.id.round_trip_checkbox)
    public void returnTripAction(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
            return_layout.setVisibility(View.GONE);
        } else {
            return_layout.setVisibility(View.VISIBLE);
        }
    }

    public OfferRideFragment() {
        // empty constractor required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_offerride, container, false);
        ButterKnife.bind(this, view);
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(getActivity(), GOOGLE_API_CLIENT_ID, this)
                .addConnectionCallbacks(this)
                .build();
        requestQueue = Volley.newRequestQueue(getActivity());
        assert offerRideLeaveFrom != null;
        offerRideLeaveFrom.setThreshold(3);
        assert offerRideGoingTo != null;
        offerRideGoingTo.setThreshold(3);
        assert offerRideStopOver != null;
        offerRideStopOver.setThreshold(3);
        googlePlaceApiAdapter = new GooglePlaceApiAdapter(getActivity(), android.R.layout.simple_list_item_1,
                INDIA_VIEW, null);
        offerRideGoingTo.setAdapter(googlePlaceApiAdapter);
        offerRideLeaveFrom.setAdapter(googlePlaceApiAdapter);
        offerRideStopOver.setAdapter(googlePlaceApiAdapter);
        addingStopOverList.setLayoutManager(new LinearLayoutManager(getActivity()));
        addingStopOverListAdapter = new AddingStopOverListAdapter(getActivity(), addingPlace);
        addingStopOverList.setAdapter(addingStopOverListAdapter);
        addingStopOverListAdapter.notifyDataSetChanged();
        new SetDatePicker(getActivity(), offerRideDepDate);
        new SetTimePicker(getActivity(), offerRideDepTime);
        new SetDatePicker(getActivity(), offerRideRetDate);
        new SetTimePicker(getActivity(), offerRideRetTime);
        offerRideStopOver.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final GooglePlaceApiAdapter.PlaceAutocomplete item = googlePlaceApiAdapter.getItem(position);
                stopover_place_layout.setVisibility(View.VISIBLE);
                addingPlace.add(new AddStopOverData(item.description.toString()));
                addingStopOverListAdapter.notifyDataSetChanged();
                Log.i(LOG_TAG, "Selected: " + item.description + " list length" + addingPlace.size());
            }
        });
        offerRideLeaveFrom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final GooglePlaceApiAdapter.PlaceAutocomplete item = googlePlaceApiAdapter.getItem(position);
                sourcePlaceId = String.valueOf(item.placeId);
                Log.i(LOG_TAG, "Selected: " + item.description + " list length" + sourcePlaceId);
            }
        });

        offerRideGoingTo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final GooglePlaceApiAdapter.PlaceAutocomplete item = googlePlaceApiAdapter.getItem(position);
                distinationPlaceId = String.valueOf(item.placeId);
                Log.i(LOG_TAG, "Selected: " + item.description);
                getDistance(sourcePlaceId, distinationPlaceId, new VolleyCallback() {
                    @Override
                    public void onSuccessResponse(String result) {
                        distance=result;
                        Log.d("VOLLEY FINAL RES",result +"  :  "+distance);
                    }
                });
            }
        });


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

    public void validateFields() {
        if (!roundTripCheckBox.isChecked()) {
            if (offerRideLeaveFrom.getText().length() <= 0 && offerRideGoingTo.getText().length() <= 0 && offerRideDepDate.getText().length() <= 0 && offerRideDepTime.getText().length() <= 0) {
                Utils.showToast(getActivity(), "Please fill all the details");
            } else {
                roundTripResult = false;
                setsharedPreferenceValue();
            }
        } else {
            if (offerRideLeaveFrom.getText().length() <= 0 && offerRideGoingTo.getText().length() <= 0 && offerRideDepDate.getText().length() <= 0 && offerRideDepTime.getText().length() <= 0 && offerRideRetDate.getText().length() <= 0 && offerRideRetTime.getText().length() <= 0) {
                Utils.showToast(getActivity(), "Please fill all the details");
            } else {
                roundTripResult = true;
                setsharedPreferenceValue();
            }
        }

    }

    public void setsharedPreferenceValue() {
        SharedPreferences prefs = getActivity().getSharedPreferences(Constants.GET_USER_PROFILE, getActivity().MODE_PRIVATE);
        userId = prefs.getString("username", null);
        sharedPreferences = getActivity().getSharedPreferences(Constants.GET_ROUTE_AND_TIME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("source", offerRideLeaveFrom.getText().toString());
        editor.putString("destination", offerRideGoingTo.getText().toString());
        editor.putString("depDateTime", offerRideDepDate.getText().toString() + " : " + offerRideDepTime.getText().toString());
        editor.putString("retDateTime", offerRideRetDate.getText().toString() + " : " + offerRideRetTime.getText().toString());
        editor.putBoolean("returnTrip", roundTripResult);
        editor.putString("userId", userId);
        editor.putString("distance", distance);
        editor.apply();
        Log.d("DISTANCE", distance);
        startActivity(new Intent(getActivity(), OfferRideActivity.class));

    }

    public void getDistance(String sourceId, String destinationId, final VolleyCallback callback) {

        requestQueue.add(new StringRequest(Request.Method.GET, Constants.GOOGLE_DISTANCE_API + sourceId + Constants.DESTINATION_METHOD + destinationId
                + Constants.MODE_KEY_METHOD + Constants.APIKEY_DISTANCE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("error_message")) {
                    try {
                        JSONObject jsonResponce = new JSONObject(response);
                        Log.d("ERROR_RESPONSE", jsonResponce.getJSONObject("error_message").toString());
                        Utils.showToast(getActivity(), jsonResponce.getJSONObject("error_message").toString());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        JSONObject jsonResponce2 = new JSONObject(response);
                        JSONArray jsonArray = jsonResponce2.getJSONArray("rows");
                        distance = jsonArray.getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("text");
                        callback.onSuccessResponse(distance);
                        Log.d("Distance VALUE", distance );

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("VOLLEY ERROR", error.toString());
            }
        }));


    }

}
