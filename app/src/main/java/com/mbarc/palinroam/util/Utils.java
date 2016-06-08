package com.mbarc.palinroam.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Admin on 6/4/2016.
 */
public class Utils {
    public static boolean isInternetWorking() {
        boolean success = false;
        try {
            URL url = new URL("https://google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(10000);
            connection.connect();
            success = connection.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static void showToast(Context context,String msg)
    {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    /**
     * Shows the progress UI and hides the  forms.
     */
    public static void showProgress(final boolean show,Context context, final View progressView, final View fromView){
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime =context.getResources().getInteger(android.R.integer.config_shortAnimTime);

            fromView.setVisibility(show ? View.GONE : View.VISIBLE);
            fromView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    fromView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            fromView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
    public static String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                        Log.i("IP_ADDRESS", "***** IP="+ ip);
                        return ip;
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("IP_ERROR", ex.toString());
        }
        return null;
    }
    public static String getDeviceId(Context context)
    {
        String ts = Context.TELEPHONY_SERVICE;
        TelephonyManager mTelephonyMgr = (TelephonyManager)context.getSystemService(ts);
        String imsi = mTelephonyMgr.getSubscriberId();
        String imei = mTelephonyMgr.getDeviceId();
        return  imei;
    }
}
