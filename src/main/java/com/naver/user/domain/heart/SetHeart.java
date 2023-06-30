package com.naver.user.domain.heart;

public class SetHeart {
    private int tid;
    private int heart;

    public SetHeart(int tid, int heart) {
        this.tid = tid;
        this.heart = heart;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }
}
