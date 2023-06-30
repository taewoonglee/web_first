package com.naver.user.domain.heart;

public class TodoHeart {
    private int id;
    private int cnt;

    public TodoHeart(int id, int cnt) {
        this.id = id;
        this.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
