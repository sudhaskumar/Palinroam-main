package com.mbarc.palinroam.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Admin on 6/14/2016.
 */
public class SessionManager {

    public void setPreferences(Context context, String key, String value) {

        SharedPreferences.Editor editor = context.getSharedPreferences("Palinroam", Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();

    }

    public  String getPreferences(Context context, String key) {

        SharedPreferences prefs = context.getSharedPreferences("Palinroam",	Context.MODE_PRIVATE);
        String position = prefs.getString(key, "");
        return position;
    }

}
