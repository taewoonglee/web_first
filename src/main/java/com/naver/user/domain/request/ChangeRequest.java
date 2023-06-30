package com.naver.user.domain.request;

public class ChangeRequest {
    private int user_id;
    private String content;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChangeRequest(int user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
