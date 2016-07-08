package com.mbarc.palinroam.data;

/**
 * Created by Admin on 7/8/2016.
 */
public class RoutePriceData {
    public String sourceCity;
    public String destinationCity;
    public int routeAmount;

    public RoutePriceData(String sourceCity, String destinationCity, int routeAmount) {
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.routeAmount = routeAmount;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public int getRouteAmount() {
        return routeAmount;
    }

    public void setRouteAmount(int routeAmount) {
        this.routeAmount = routeAmount;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public String toString() {
        return "RoutePriceData{" +
                "sourceCity='" + sourceCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", routeAmount=" + routeAmount +
                '}';
    }
}
