package com.mbarc.palinroam.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Admin on 6/6/2016.
 */
public class JsonObjectBulider {
    public static JSONObject userCredantials(String loginId,String password ,JSONObject sessionObj){
        JSONObject userCred=new JSONObject();
        try {
            userCred.put("loginId",loginId);
            userCred.put("password",password);
            userCred.put("session",sessionObj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userCred;
    }

    public static JSONObject sessionDetails(String sessionId,String ipAddress ,String deviceId){
        JSONObject sesDetails=new JSONObject();
        try {
            sesDetails.put("sessionId",sessionId);
            sesDetails.put("ipAddress",ipAddress);
            sesDetails.put("deviceId",deviceId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sesDetails;
    }
    public static JSONObject personNameDetails(String firstName,String middleName ,String lastName,String nickName){
        JSONObject perNameDetails=new JSONObject();
        try {
            perNameDetails.put("firstName",firstName);
            perNameDetails.put("middleName",middleName);
            perNameDetails.put("lastName",lastName);
            perNameDetails.put("nickName",nickName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return perNameDetails;
    }
    public static JSONObject errorResponses(String errorCode,String errorMessage){
        JSONObject errorJsonObj=new JSONObject();
        try {
            errorJsonObj.put("errorCode",errorCode);
            errorJsonObj.put("errorMessage",errorMessage);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorJsonObj;
    }
    public static JSONObject postRideRequest(String userId,String SourceLocation ,String Destination,Boolean Roundtrip,String DepartureDateTime,String ReturnDateTime,String PreferedCoPassenger,int NoOfSeats,String Luggage,String RideCertainity,String CancellationPolicy ){
        JSONObject postRequestParams=new JSONObject();
        try {
            postRequestParams.put("userId",userId);
            postRequestParams.put("SourceLocation",SourceLocation);
            postRequestParams.put("Destination",Destination);
            postRequestParams.put("Roundtrip",Roundtrip);
            postRequestParams.put("DepartureDateTime",DepartureDateTime);
            postRequestParams.put("ReturnDateTime",ReturnDateTime);
            postRequestParams.put("PreferedCoPassenger",PreferedCoPassenger);
            postRequestParams.put("NoOfSeats",NoOfSeats);
            postRequestParams.put("Luggage",Luggage);
            postRequestParams.put("RideCertainity",RideCertainity);
            postRequestParams.put("CancellationPolicy",CancellationPolicy);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return postRequestParams;
    }
}
