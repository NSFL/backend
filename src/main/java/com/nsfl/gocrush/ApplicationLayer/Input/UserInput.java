package com.nsfl.gocrush.ApplicationLayer.Input;

public class UserInput {

    private String userID;
    private String crushID;

    public UserInput(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public String getCrushID() {
        return crushID;
    }

}