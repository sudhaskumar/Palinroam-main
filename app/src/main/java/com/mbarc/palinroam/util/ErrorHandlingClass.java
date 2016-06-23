package com.mbarc.palinroam.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Admin on 6/14/2016.
 */
public class ErrorHandlingClass {

    public void ErrorHandlingClass(Context context,String errorCode, String errorMessage) {
        if(errorCode.equalsIgnoreCase("1"))
        {
            Utils.showToast(context,errorMessage);
        }else if(errorCode.equalsIgnoreCase("2049"))
        {
            Utils.showToast(context,errorMessage);
        }
        else if(errorCode.equalsIgnoreCase("5"))
        {
            Utils.showToast(context,errorMessage);
        }
        else if(errorCode.equalsIgnoreCase("3"))
        {
            Utils.showToast(context,errorMessage);
        } else if(errorCode.equalsIgnoreCase("17"))
        {
            Utils.showToast(context,errorMessage);
        }else{
            Utils.showToast(context,errorMessage);

        }
    }
}
