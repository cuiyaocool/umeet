package com.example.redisdelay.info;

import java.io.Serializable;

public class RedisDelayInfoData implements Serializable {
    int idx;
    String message;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RedisDelayInfoData(int i, String mes) {
        idx = i;
        message = mes;
    }

    public RedisDelayInfoData() {}
}
