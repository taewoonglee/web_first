package com.naver.user.domain.request;

public class UpdateRequest {
   private String content;
   private int id;
   private int user_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public UpdateRequest(String content, int id, int user_id) {
        this.content = content;
        this.id = id;
        this.user_id = user_id;
    }
    //    public Update toDto(int uid){
//        return new Update(id,uid,content);
//    }
}
