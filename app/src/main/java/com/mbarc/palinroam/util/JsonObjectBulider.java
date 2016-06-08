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
}
