package com.nsfl.gocrush.Utility;

public class AccessToken {

    private String access_token;
    private String token_type;
    private String expires_in;

    public AccessToken(String access_token, String token_type, String expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }
}
