package com.mbarc.palinroam.data;

/**
 * Created by Sudhas on 6/9/2016.
 */
public class ConnectFriendsData {

    public String connectFriendName;
    public String connectFriendAge;
    public String connectFriendNoOfMutuals;
    public Boolean connectFriendFlag;
    public String connectFriendImageUrl;
    public String connectFriendRatings;

    public ConnectFriendsData(String connectFriendName, String connectFriendAge, String connectFriendNoOfMutuals, Boolean connectFriendFlag, String connectFriendImageUrl, String connectFriendRatings) {
        this.connectFriendName = connectFriendName;
        this.connectFriendAge = connectFriendAge;
        this.connectFriendNoOfMutuals = connectFriendNoOfMutuals;
        this.connectFriendFlag = connectFriendFlag;
        this.connectFriendImageUrl = connectFriendImageUrl;
        this.connectFriendRatings = connectFriendRatings;
    }

    public String getConnectFriendName() {
        return connectFriendName;
    }

    public void setConnectFriendName(String connectFriendName) {
        this.connectFriendName = connectFriendName;
    }

    public String getConnectFriendAge() {
        return connectFriendAge;
    }

    public void setConnectFriendAge(String connectFriendAge) {
        this.connectFriendAge = connectFriendAge;
    }

    public String getConnectFriendNoOfMutuals() {
        return connectFriendNoOfMutuals;
    }

    public void setConnectFriendNoOfMutuals(String connectFriendNoOfMutuals) {
        this.connectFriendNoOfMutuals = connectFriendNoOfMutuals;
    }

    public Boolean getConnectFriendFlag() {
        return connectFriendFlag;
    }

    public void setConnectFriendFlag(Boolean connectFriendFlag) {
        this.connectFriendFlag = connectFriendFlag;
    }

    public String getConnectFriendImageUrl() {
        return connectFriendImageUrl;
    }

    public void setConnectFriendImageUrl(String connectFriendImageUrl) {
        this.connectFriendImageUrl = connectFriendImageUrl;
    }

    public String getConnectFriendRatings() {
        return connectFriendRatings;
    }

    public void setConnectFriendRatings(String connectFriendRatings) {
        this.connectFriendRatings = connectFriendRatings;
    }

    @Override
    public String toString() {
        return "ConnectFriendsData{" +
                "connectFriendName='" + connectFriendName + '\'' +
                ", connectFriendAge='" + connectFriendAge + '\'' +
                ", connectFriendNoOfMutuals='" + connectFriendNoOfMutuals + '\'' +
                ", connectFriendFlag=" + connectFriendFlag +
                ", connectFriendImageUrl='" + connectFriendImageUrl + '\'' +
                ", connectFriendRatings='" + connectFriendRatings + '\'' +
                '}';
    }
}
