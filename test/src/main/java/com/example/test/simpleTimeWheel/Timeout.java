package com.example.test.simpleTimeWheel;

public interface Timeout {
    Timer timer();
    TimerTask task();
    boolean isExpired();

}
