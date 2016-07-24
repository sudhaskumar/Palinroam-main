package com.mbarc.palinroam.constants;

/**
 * Created by sudhas on 5/31/2016.
 */
public class Constants {
    /**
     * Id to identity READ_CONTACTS permission request.
     */
    public static final int REQUEST_READ_CONTACTS = 0;

    //Toast messages
    public static final String NO_NETWORK="Internet Not Available";
    public static final String NETWORK_AVAILABLE="Internet Available";
    public static final String SERVER_ERROR="Something went wrong ,Please try again later ";
    //Project URL Constants and Methods
    //google_api
    public static final String GOOGLE_DISTANCE_API="https://maps.googleapis.com/maps/api/distancematrix/json?origins=place_id:";
    public static final String DESTINATION_METHOD="&destinations=place_id:";
    public static final String MODE_KEY_METHOD="&mode=driving&key=";
    public static final String APIKEY_DISTANCE="AIzaSyCzRnECflaj1YJx3OD8Qo2tpOL5uQqqFCc";
   //own url api
    public  static final  String MAINURL="http://ec2-54-191-144-166.us-west-2.compute.amazonaws.com:4321/webservices-1.0.0-BUILD-SNAPSHOT/rest/user/";
    public static final String OPTIONALURL="http://54.191.144.166:8000/";
    public  static final  String REGISTERATION_METHOD="register";
    public  static final  String LOGIN_METHOD="login";
    public  static final  String GET_USER_PROFILE="getUserProfile";
    public  static final  String GET_ROUTE_AND_TIME="getRouteAndTime";
    public static final String POSTRIDE_METHOD="rides";

    //hardware access id
    public final static int PICK_PHOTO_CODE = 1046;
    public final static int CAPTURE_REQUEST_CODE = 1056;
}
