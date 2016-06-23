package com.mbarc.palinroam.data;

/**
 * Created by Admin on 6/20/2016.
 */
public class StopOverData {

    public String sourceName;
    public String destinationName;
    public String kmsCount;
    public String rateOfAmt;

    public StopOverData(String sourceName, String destinationName, String kmsCount, String rateOfAmt) {
        this.sourceName = sourceName;
        this.destinationName = destinationName;
        this.kmsCount = kmsCount;
        this.rateOfAmt = rateOfAmt;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getKmsCount() {
        return kmsCount;
    }

    public void setKmsCount(String kmsCount) {
        this.kmsCount = kmsCount;
    }

    public String getRateOfAmt() {
        return rateOfAmt;
    }

    public void setRateOfAmt(String rateOfAmt) {
        this.rateOfAmt = rateOfAmt;
    }

    @Override
    public String toString() {
        return "StopOverData{" +
                "sourceName='" + sourceName + '\'' +
                ", destinationName='" + destinationName + '\'' +
                ", kmsCount='" + kmsCount + '\'' +
                ", rateOfAmt='" + rateOfAmt + '\'' +
                '}';
    }
}
