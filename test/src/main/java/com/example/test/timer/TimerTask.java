package com.example.test.timer;

public interface TimerTask {
    void run(Timeout timeout, String argv) throws Exception;
}
