package com.mbarc.palinroam.data;

/**
 * Created by Sudhas on 6/9/2016.
 */
public class TaggedFriendsData {

    public String taggedFriendName;
    public String taggedtFriendAge;
    public String taggedFriendNoOfFriends;
    public String taggedFriendImageUrl;

    public TaggedFriendsData(String taggedFriendNoOfFriends, String taggedFriendName, String taggedtFriendAge, String taggedFriendImageUrl) {
        this.taggedFriendNoOfFriends = taggedFriendNoOfFriends;
        this.taggedFriendName = taggedFriendName;
        this.taggedtFriendAge = taggedtFriendAge;
        this.taggedFriendImageUrl = taggedFriendImageUrl;
    }

    public String getTaggedFriendName() {
        return taggedFriendName;
    }

    public void setTaggedFriendName(String taggedFriendName) {
        this.taggedFriendName = taggedFriendName;
    }

    public String getTaggedtFriendAge() {
        return taggedtFriendAge;
    }

    public void setTaggedtFriendAge(String taggedtFriendAge) {
        this.taggedtFriendAge = taggedtFriendAge;
    }

    public String getTaggedFriendNoOfFriends() {
        return taggedFriendNoOfFriends;
    }

    public void setTaggedFriendNoOfFriends(String taggedFriendNoOfFriends) {
        this.taggedFriendNoOfFriends = taggedFriendNoOfFriends;
    }

    public String getTaggedFriendImageUrl() {
        return taggedFriendImageUrl;
    }

    public void setTaggedFriendImageUrl(String taggedFriendImageUrl) {
        this.taggedFriendImageUrl = taggedFriendImageUrl;
    }

    @Override
    public String toString() {
        return "TaggedFriendsData{" +
                "taggedFriendName='" + taggedFriendName + '\'' +
                ", taggedtFriendAge='" + taggedtFriendAge + '\'' +
                ", taggedFriendNoOfFriends='" + taggedFriendNoOfFriends + '\'' +
                ", taggedFriendImageUrl='" + taggedFriendImageUrl + '\'' +
                '}';
    }
}
