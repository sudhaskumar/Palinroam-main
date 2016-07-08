package com.mbarc.palinroam.data;

/**
 * Created by Sudhas on 6/9/2016.
 */
public class AddCarData {

    public String carName;
    public String carColor;
    public String carDesc;
    public String carImageUrl;


    public AddCarData(String carName, String carColor, String carDesc, String carImageUrl) {
        this.carName = carName;
        this.carColor = carColor;
        this.carDesc = carDesc;
        this.carImageUrl = carImageUrl;

    }


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }

    public String getCarImageUrl() {
        return carImageUrl;
    }

    public void setCarImageUrl(String carImageUrl) {
        this.carImageUrl = carImageUrl;
    }
}