package com.mbarc.palinroam.util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.mbarc.palinroam.constants.Constants;

import org.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhas on 6/6/2016.
 */
public class BaseRequest extends JsonObjectRequest {
    public BaseRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");
       // headers.put("User-agent", System.getProperty("http.agent"));

        return headers;
    }
    public static void onError(Context context) {
        Utils.showToast(context, Constants.SERVER_ERROR);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        if (response.headers == null) {
            // cant just set a new empty map because the member is final.
            response = new NetworkResponse(
                    response.statusCode,
                    response.data,
                    Collections.<String, String>emptyMap(), // this is the important line, set an empty but non-null map.
                    response.notModified);
        }
        return super.parseNetworkResponse(response);
    }

}
