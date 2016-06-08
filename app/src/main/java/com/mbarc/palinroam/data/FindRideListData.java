package com.mbarc.palinroam.data;


/**
 * Created by sudhas on 6/3/2016.
 */
public class FindRideListData {

    public String name;
    public String age;
    public String numberOfFriends;
    public String numberOfMutualFriends;
    public String amtPerSeat;
    public String startDate;
    public String startTime;
    public String userRating;
    public String availableSeat;
    public String verifiedMemberFlag;
    public String flagForGender;
    public String certaintyType;
    public String amtType;

    public FindRideListData(String name, String age, String numberOfFriends, String numberOfMutualFriends, String amtPerSeat, String startDate, String startTime, String userRating, String availableSeat, String certaintyType) {
        this.name = name;
        this.age = age;
        this.numberOfFriends = numberOfFriends;
        this.numberOfMutualFriends = numberOfMutualFriends;
        this.amtPerSeat = amtPerSeat;
        this.startDate = startDate;
        this.startTime = startTime;
        this.userRating = userRating;
        this.availableSeat = availableSeat;
        this.certaintyType = certaintyType;
    }

    public FindRideListData(String name, String age, String numberOfFriends, String numberOfMutualFriends, String amtPerSeat, String startDate, String startTime, String userRating, String availableSeat, String verifiedMemberFlag, String flagForGender, String certaintyType, String amtType) {
        this.name = name;
        this.age = age;
        this.numberOfFriends = numberOfFriends;
        this.numberOfMutualFriends = numberOfMutualFriends;
        this.amtPerSeat = amtPerSeat;
        this.startDate = startDate;
        this.startTime = startTime;
        this.userRating = userRating;
        this.availableSeat = availableSeat;
        this.verifiedMemberFlag = verifiedMemberFlag;
        this.flagForGender = flagForGender;
        this.certaintyType = certaintyType;
        this.amtType = amtType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNumberOfFriends() {
        return numberOfFriends;
    }

    public void setNumberOfFriends(String numberOfFriends) {
        this.numberOfFriends = numberOfFriends;
    }

    public String getNumberOfMutualFriends() {
        return numberOfMutualFriends;
    }

    public void setNumberOfMutualFriends(String numberOfMutualFriends) {
        this.numberOfMutualFriends = numberOfMutualFriends;
    }

    public String getAmtPerSeat() {
        return amtPerSeat;
    }

    public void setAmtPerSeat(String amtPerSeat) {
        this.amtPerSeat = amtPerSeat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        startTime = startTime;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(String availableSeat) {
        this.availableSeat = availableSeat;
    }

    public String getVerifiedMemberFlag() {
        return verifiedMemberFlag;
    }

    public void setVerifiedMemberFlag(String verifiedMemberFlag) {
        this.verifiedMemberFlag = verifiedMemberFlag;
    }

    public String getFlagForGender() {
        return flagForGender;
    }

    public void setFlagForGender(String flagForGender) {
        this.flagForGender = flagForGender;
    }

    public String getCertaintyType() {
        return certaintyType;
    }

    public void setCertaintyType(String certaintyType) {
        this.certaintyType = certaintyType;
    }

    public String getAmtType() {
        return amtType;
    }

    public void setAmtType(String amtType) {
        this.amtType = amtType;
    }

    @Override
    public String toString() {
        return "FindRideListData{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", numberOfFriends='" + numberOfFriends + '\'' +
                ", numberOfMutualFriends='" + numberOfMutualFriends + '\'' +
                ", amtPerSeat='" + amtPerSeat + '\'' +
                ", StartDate='" + startDate + '\'' +
                ", StartTime='" + startTime + '\'' +
                ", userRating='" + userRating + '\'' +
                ", availableSeat='" + availableSeat + '\'' +
                ", verifiedMemberFlag='" + verifiedMemberFlag + '\'' +
                ", flagForGender='" + flagForGender + '\'' +
                ", certaintyType='" + certaintyType + '\'' +
                ", amtType='" + amtType + '\'' +
                '}';
    }
}
