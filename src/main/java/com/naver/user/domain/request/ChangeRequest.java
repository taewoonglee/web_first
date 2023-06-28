package com.naver.user.domain.request;

public class ChangeRequest {
    private String user_id;
    private String content;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChangeRequest(String user_id, String content) {
        this.user_id = user_id;
        this.content = content;
    }
}
