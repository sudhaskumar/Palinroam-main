package com.mbarc.palinroam.data;

/**
 * Created by Admin on 6/20/2016.
 */
public class AddStopOverData {

   public String stopOverCityNameText;

    public String getStopOverCityNameText() {
        return stopOverCityNameText;
    }

    public void setStopOverCityNameText(String stopOverCityNameText) {
        this.stopOverCityNameText = stopOverCityNameText;
    }

    public AddStopOverData(String stopOverCityNameText) {

        this.stopOverCityNameText = stopOverCityNameText;
    }

    @Override
    public String toString() {
        return "AddStopOverData{" +
                "stopOverCityNameText='" + stopOverCityNameText + '\'' +
                '}';
    }
}
