package com.mbarc.palinroam.data;

/**
 * Created by Sudhas on 6/9/2016.
 */
public class FriendsData {

    public String friendName;
    public String friendAge;
    public String friendNoOfMutuals;
    public Boolean friendFlag;
    public String friendImageUrl;
    public String friendRatings;

    public FriendsData(String friendName, String friendAge, String friendNoOfMutuals, Boolean friendFlag, String friendImageUrl, String friendRatings) {
        this.friendName = friendName;
        this.friendAge = friendAge;
        this.friendNoOfMutuals = friendNoOfMutuals;
        this.friendFlag = friendFlag;
        this.friendImageUrl = friendImageUrl;
        this.friendRatings = friendRatings;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendAge() {
        return friendAge;
    }

    public void setFriendAge(String friendAge) {
        this.friendAge = friendAge;
    }

    public String getFriendNoOfMutuals() {
        return friendNoOfMutuals;
    }

    public void setFriendNoOfMutuals(String friendNoOfMutuals) {
        this.friendNoOfMutuals = friendNoOfMutuals;
    }

    public Boolean getFriendFlag() {
        return friendFlag;
    }

    public void setFriendFlag(Boolean friendFlag) {
        this.friendFlag = friendFlag;
    }

    public String getFriendImageUrl() {
        return friendImageUrl;
    }

    public void setFriendImageUrl(String friendImageUrl) {
        this.friendImageUrl = friendImageUrl;
    }

    public String getFriendRatings() {
        return friendRatings;
    }

    public void setFriendRatings(String friendRatings) {
        this.friendRatings = friendRatings;
    }

    @Override
    public String toString() {
        return "FriendsData{" +
                "friendName='" + friendName + '\'' +
                ", friendAge='" + friendAge + '\'' +
                ", friendNoOfMutuals='" + friendNoOfMutuals + '\'' +
                ", friendFlag=" + friendFlag +
                ", friendImageUrl='" + friendImageUrl + '\'' +
                ", friendRatings='" + friendRatings + '\'' +
                '}';
    }
}
