package com.example.demo.exception;
public class MemberNotFound extends NullPointerException {
    private String api;
    private String memberId;

    public MemberNotFound(String s, String api, String memberId) {
        super(s);
        this.api = api;
        this.memberId = memberId;
    }

    public String getApi() {
        return api;
    }

    public String getMemberId() {
        return memberId;
    }
}
